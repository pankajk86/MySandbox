## Yelp

### Functional requirements:
1. User should be able to search nearby restaurants.
   * search by category, name, rating.
2. User should be able to look up the details of a given restaurant.
3. User should post review and ratings.

### Non-functional requirements:
1. read >> write.
2. High availability.
3. Eventual consistency.
4. Low latency:
   * search / drill down : 500 ms
   * write (reviews) : 1 minute
5. No duplicate reviews by a user for a business.
6. Scale : 
   * 10 million businesses
   * 100 million DAU

### Core entities:
* restaurants
* users
* reviews

### APIs:

* `GET /search/?query=query_term&filter=category|name|rating`
  *  Response: List of restaurants : (restaurant_id, name, category, total_rating, total_reviews)
* `GET /search/?id=restaurant_id`
  * Response: restaurant (restaurant_id, name, avg_rating, summary)
* `GET /search/reviews/?id=restaurant_id`
  * Response: list of restaurant reviews (review_id, rating, review, created_at)
* `POST /review`
  * Request: restaurant_id, rating, review
  * Response: 200


### High Level design

![](/resources/IMG_5348.png)

* Choice of DB : MySQL
  * Since read is more heavy than the write, single leader replication is easiest.
  * Partition the `restaurant` and `reviews` table by hash range of `restaurant_id`.
* New reviews can be added two ways:
  * Two Phase commit (2PC) when a new review is submitted. **We can use this, because write is not that frequent.**
  * Change data capture (CDC) on review tables.
* To serve search and read queries, we will use ElasticSearch:
  * Support geospatial indexing with the help of geoDistance query.
  * Inverted index can be leveraged for free form text search.

### Dive Deep

![](/resources/IMG_5349.png)

* Caching:
  * cache popular results, either by place or restaurant's name.
  * write around cache, as we don't know in advance which restaurants can be popular.
* Geo sharding:
  * Some small area, like SF or NY can have many restaurants; large area in midwest has very few.
  * If we create shards based on the geohash, then a shard containing the popular areas may become very hot.
  * Solution:
    * partition by geohash range - two locations with similar geo-hashes are geographically close by.
    * We can calculate which geo-hashes are getting more traffic.
    * Partition them in order to make the number of restaurants (geo-hashes) in each partition almost equal.
    * It would be a one time (or not very frequent) analysis, and can be based on performance and or load testing.

