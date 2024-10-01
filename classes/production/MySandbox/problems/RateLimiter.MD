## Rate Limiter

### Functional requirements:
- Server-side API rate limiter.
- Accurately limit excessive requests.
- Exception handling.

### Non-functional requirements:
- Low latency.
- Use as little memory as possible.
- High fault tolerance.

### Note
API Gateway - Fully managed service that supports rate limiting, authentication, servicing static content, etc.

### Algorithms
* Token bucket:
  * Parameters:
    * Initial capacity of the bucket
    * Token refill with scheduled interval.
    * If token available, request will be served; token reduced by 1.
  * **Key rate limiting rule**:
    * Different bucket for different APIs.
    * If throttling on IP address, each IP address will need another bucket.
  * Pros:
    * Memory efficient
    * Allows burst of traffic for short periods.
  * Cons:
    * Tricky to tune the parameters.
* Leaky bucket:
  * Parameters:
    * FIFO queue (bucket) size
    * Outflow rate - rate at which requests are being processed.
  * Pros:
    * Memory efficient
    * Requests are processed at fixed rate.
  * Cons:
    * Burst of traffic fills up the queue with old requests; if not processed, new requests will be throttled.
* Fixed window counter
* Sliding window log

### High-level design
![](/resources/IMG_5316.png)

* Two main components:
  * Rate limiter middleware
  * Cache (Redis)

### Detailed Design
![](/resources/IMG_5317.png)

* Flow:     
  * Rules stored in disk; pulled frequently from disk to store in cache.
  * Clients requests are intercepted at the Rate limiter middleware (RLM) first.
  * RLM loads the rule from cache. It also fetches counters and last request timestamp from Redis cache.
    * If request is not rate limited, it is forwarded to API servers.
    * Otherwise, returns HTTP error 429 (too many requests), and requests are dropped or queued.

### Distributed environment

* Issues:
  * Race condition
    * Solution:
      * Locks will slow down the system.
      * **Recommended** - Lua script, or sorted set data structure in Redis.
  * Synchronization issues
    * Solution:
      * Use centralized data store like Redis to store counter information.