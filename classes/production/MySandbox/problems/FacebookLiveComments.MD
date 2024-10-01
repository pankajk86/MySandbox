## Facebook Live comments

### Functional requirements:
1. Viewers can post comments.
2. Viewers can see all comments.
3. Viewers can see comments posted before they joined the live feed.

- Viewers can reply to comments
- Reply can contain media as content.
- Viewers can react to comments

### Non-functional requirements:
1. Support upto millions of concurrent viewers, and thousands of comments per second.
2. Prioritize availability over consistency.
3. Low latency; broadcasting comments to viewers in near real time.


bytes * 10^3 = KB * 10^3 = MB * 10^3 = GB * 10^3 = TB * 10^3 = PB

### Core entities:

* User
* Live Video
* Comments

### API Design:

* `POST /comment/create`
  * Request: 
    * liveVideoId
    * message
  * Response:
    * 200
* `GET /comments/{liveVideoId}`
  * Response : Stream of comments

### High level design:

![](/resources/IMG_5342.png)

* Centralized **comment management service**.
  * It will persist comment in DB, and sent it to the viewers over SSE.
* Database choice: DynamoDB
  * Reasons: 
    * Need to horizontally scale.
    * Document based NoSQL database to store comments. 
    * No need to maintain any complex relationships with other entities.
* Broadcasting comments to viewers over **Server Sent events (SSE)**.
  * Other options are:
    * Polling
      * Cons : 
        * Not very efficient w.r.t to network calls.
        * Stale or missing comments until the next poll.
    * Web-sockets:
      * Cons:
        * Good for use cases where write and read ratio is almost equal.
  * SSE is based on HTTP so no additional infrastructure is needed to set it up.
* In order to load comments before the viewer joined:
  * Cursor pagination with prefetching and caching
    * Cursor points to the latest comments.
    * When user scrolls for more comments, the system will prefetch and cache more comments.
    * Upon further scroll, the comments will be fetched from the cache efficiently.

### Deep dive:

![](/resources/IMG_5343.png)

* Scale to support millions of concurrent viewers.
  * Good solution:
    * Pub/Sub partitioning into topics per live video.
      * Partition comment stream into different topics base on live video.
      * Each realtime messaging server (RMS) will subscribe to only the topics it needs.
      * Challenge:
        * Different viewer can switch between different videos.
  * Great solution:
    * Pub/Sub partitioning into topics per live video with L7 load balancer.
      * L7 load balancer can route traffic to a given RMS based on the request.
      * All requests for a given live video can be handled by one (or more replicas) of hosts.
      * RMSs, as in the previous option, will subscribe to limited set of video topics.
      * This way it reduces the network and computation requirements.
      * Challenge:
        * One (or set of) RMSs may be overloaded if a given video becomes very hot.
        * In that case, we might to come up with a strategy to scale up the RMSs to ease the load.
* Pub-Sub system to use:
  * Options:
    * Redis Pub/Sub
    * Kafka
  * The current situation needs faster retrieval (consumption) of comments.
  * Also subscription / unsubscription is dynamic in the current requirement.
  * Kafka may be slow for that.
  * Hence choosing Redis pub/sub