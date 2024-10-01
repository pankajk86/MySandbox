## Tweet Search

### Functional requirements:
1. User should be able to search for tweets containing search terms.
2. User should be able to select the sort order by time or likes.
3. User should be able to search results upto k (=100) pages.

- Fuzzy matching ("rail" for "train", etc.)
- Relevance algorithms based on user's search history.
- Real-time updates.

### Non-functional requirements"
1. The system should have low latency (< 200 ms).
2. The system should support high volume of search request.
3. Eventual consistency for the new tweets, i.e. they can be searched with a small delay in time (~20 seconds).
4. The system should be highly available.


### Core entities:

* User
* Tweet (tweet_id, author, content, likes, timestamp)


### API design:

* `GET /v1/search/?query=search_term&sort_order=time|likes`
  * Response: List of N tweets.
    * Upon scrolling, more tweets can be loaded.


### High Level Design

![](/resources/IMG_5344.png)

* Tweet Service to handle tweet posts.
* Writes to Tweet DB.
  * Choice of DB : Cassandra 
    * Reason: 
      * Though queries will be more, but still write heavy.
      * Horizontal scaling, and possible to apply partition and sorting.
* Leverage Kafka queue to process CDC from the DB to index into ElasticSearch.
* Like Aggregator will update the like counter for a post, and update the post likes after certain interval. 
* Dedicated Service, Ranking Service, which will fetch results from elastic search index, and apply necessary sorting.

### Dive Deep:

![](/resources/IMG_5345.png)

* Local vs global index for ElasticSearch
  * Local is preferred
* Different ingestion and aggregation window size for likes:
  * Likes has more QPS than tweet creation, hence need to reduce the load on the ES cluster.
* Pagination cache in addition to search cache.
  * Search cache will be used to serve queries if they are searched before.
    * In case of cache miss, ES will be searched.
  * Pagination cache will be used to infinite scrolling, in case user want to search more.
* Ranking service:
  * It may need to search over multiple partitions, if result not found in the cache, and the search term is present over multiple partitions.

