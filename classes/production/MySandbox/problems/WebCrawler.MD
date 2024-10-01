## Web Crawler

It is preferably a System design (infra) problem, as compared to Product Architecture problem.
In that sense, the focus will be more on scale of the solution.

### Functional requirements:
1. Crawl the web starting from set of seed URLs.
2. Extract data and store.

### Non-functional requirements:
1. Fault tolerant
2. Politeness
3. Scale up to 10 billion pages.
4. Efficiently crawl in 5 days.

### Scale:

* 10 billion pages
* 2 MB per page.
* 5 days to crawl

### Core Entities:

* **Text Data** - Blob that forms the content of a crawled page.
* **URL metadata** - URL, and related metadata
* **Domain metadata** - policies for a given domain in order to comply while crawling.


### Interface

* **Input**: set of seed URLs
* **Output**: text data extracted by crawling the internet.

### Data Flow

1. Take the seed URLs from a frontier, and IP from DNS.
2. Fetch the HTML.
3. Extract text from HTML.
4. Store the text in database.
5. Extract URLs in the text and add to the frontier.
6. Repeat 1-5 until all URLs have been crawled.

### High Level Design

![](/resources/IMG_5329.png)

* Crawler is responsible for most of the processing. 
* After fetching the text data, it will store it in S3.
* It adds the newly extracted URLs into the frontier.

### Dive deep

![](/resources/IMG_5330.png)

* Decouple fetching the web-page from processing it.
  * We introduce async message queue (like Kafka), where crawler will add the S3 details of the fetched content.
  * Worker nodes, like Flink based, will consume Kafka messages to process the data further.
    * Extract text from HTML.
    * Extract URLs from texts.
    * Add URLs to the frontier.
    
* Queue selection for frontier queue should allow retry for fetching a web page.
  * Web pages be down, or no more available.
  * We can have kafka queues, by will need to configure it to retry for unhealthy URLs.
  * Better option is to use AWS SQS queue:
    * It supports retry mechanism (visibility timeout) out of the box.
    * Since the different URLs are not related to each other, processing it separately works fine in SQS.

* Politeness:
  * Each domain has a file named "robots.txt", which stores rules for external crawlers. e.g.
    * Which URLs in the domain are not allowed to be crawled.
    * Between two crawl requests, what is the required delay.
  * In first crawl attempt, the crawler will access the domain's robots.txt.
  * It will store the content / policies in a storage.
  * Before next attempt, it will validate if the URL and request complies to the domain's rules.
  * It may happen that domain has updated their robots.txt.
    * In that case, we may have a scheduled job to run after certain interval, like once a month to update the local robots.txt content.
  * Irrespective of domain policies, it's a good practice to have rate limiting based on domain.
    * A jitter (random delay on top of rate limiting delay) should be added.
    * It will help different crawlers hit webpage at different time.

* Avoid URLs from the same domain at the same time to improve efficiency of the crawler.
  * Flink worker will store extracted URLs into the URL metadata instead of frontier.
  * A smart scheduler will load URLs from URL metadata table.
    * It will follow certain algorithm so that not all URLs are from the same domain.

* Avoid duplicate crawling, or falling into traps:
  * We should not crawl the same URL twice.
  * We should not crawl and / or processing webpages with duplicate contents.
    * Crawler will create the hash of the HTML, and checks if a URL exists in table with the same hash.
    * If doesn't exist, add the URL in the Kafka queue, otherwise, don't put it.
  * For traps, we can set a max_depth, like 20.

* Improve on DNS lookups:
  * DNS caching
    * DNS also have rate limiting implemented, so we don't want to request them for all requests.
    * We can cache the DNS details in the Redis cluster (used for internal rete limiting).
  * Register to multiple DNSs for lookups.
    * With multiple DNS providers, we can implement some round-robin approach for lookup.
    * In conjunction with DNS caching, it will improve DNS lookups.


