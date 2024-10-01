## News Feed System

### Functional requirements:
1. User can publish post.
   * Post can have media (images, videos) in addition to text.
2. User should see her friend's post on the news feed page.
3. User should be able to page through the feed.

### Non-functional requirements:
1. The system is much more read heavy than write.
2. User can quickly see who are they are following, and by whom they are followed.
3. Low latency when a user accesses the news feed.

### Back-of-the-envelope estimation:

bytes * 10^3 = KB * 10^3 = MB * 10^3 = GB * 10^3 = TB * 10^3 = PB

* DAU: 100 million
* Friends / followers 
  * Normal user: 500
  * Verified users (influencers): 1 million
* Posts per day :
  * 10% of DAU : 10 million * 1 post per user per day = 10 million posts
* Size of each post:
  * 100 chars + metadata = (100 + 100) bytes = 200 bytes.
  * avg media size : 1 mb
* Storage per day : 10 million * 1 mb = 10TB per day
  * We can cache it (for better read throughput)
    * 256 GB machine - 40 for single replica
    * 100 for double replica (not that bad)
  * We won't cache influencer's post to followers news feed.
* Storage per year : 10 TB * 400 = 4 PB per year.


### API design:

* `POST /v1/post` - publish a post
  * Request:
    * content: text + media (optional)
    * userId, authentication details, etc. - request headers
    * timestamp - system generated.
* `GET /v1/feed` - retrieve the news feed
  * Request:
    * userId, authentication details, etc. - request headers
* `GET /v1/posts/{user-id}` - retrieve posts by a given user

### Database schema:

* **User tables**
  * DB to use: cassandra
    * Pros:
      * leaderless architecture
      * fast write - writes are cached in memory, and based on LSM tree.
  * **user_followers** : get all users who follow user x.
    * schema:
      * user_id (partition_key) - all followers for a given user will be in the same partition.
      * follower_id
  * **user_following** : get all users who are followed by user x.
    * schema:
      * user_id (partition_key)
      * followee_id
*  **Post table**
* DB to use: cassandra
* **user_posts**: get all posts by user x.
  * schema:
    * user_id (partition_key)
    * timestamp (cluster_key)
    * content
    * s3_url

### High level design:


### Deep dive:

* **Feed publishing**:

![](/resources/IMG_5318.png)

* **Fanout service**
  * More specifically, **fanout on write**. 
  * Fans out posts for normal (un-verified, or non-influencers) users. 
  * Updates new feed cache for all the users who follow the poster (user who posts).
  * For influencers / verified users, news feed will be updated on read. More details below.
* News feed cache stores <post_id, user_id>.

* **Newsfeed retrieval**

![](/resources/IMG_5319.png)

* **Newsfeed service**
  * Retrieves <post_id, user_id> from news feed cache.
  * Builds post for the given post_id from the post cache - I.
  * Checks the "verified users that curr user follows" cache for any verified users.
  * Fetches any posts from any of the verified users, that curr user follows - II.
  * Fetches curr user details from the user cache - III.
  * Merges I, II, and III, with I, and II sorted anti-chronological order.

