## Proximity Service

### Functional requirements:
1. Return all businesses based on a user's location (lat-long pair), and given radius.
2. Businesses can be added, deleted, or updated. No need to be reflected in real-time.
3. Customers can view detailed information about a business.

### Non-functional requirements:
- Low latency 
- High-availability and scalability requirements:
  - Prepared for peak traffic in densely populated areas.

### Back-of-the-envelope estimation:
- 100 million DAU
- 200 million businesses
- Customers have 5 read requests per day, on average.

seconds per day = 100K

QPS = 100 million * 5 / 100k = 5000


### API Design:
* **GET /v1/search/near-me**  (Location Based Service, i.e. LBS)
  * Request:
    * latitude - decimal
    * longitude - decimal
    * radius - int (some default value, say 5 miles)
  * Response:
    ```
    {
      "total": 10,
      "businesses": [{business_objects}]
    }
    ```
    `business_objects` will contain pictures S3 URL, reviews, star ratings, etc.


* Business service
* **GET /v1/businesses/{id}** - return business details
* **POST /v1/businesses/** - add a new business_object
* **PUT /v1/businesses/{id}** - update a given business_object
* **DELETE /v1/businesses/{id}** - delete a given business_object

### Data schema
* System will be read heavy:
  * Nearby businesses.
  * Detailed business info.


* **Business table**: (detail about the business_object)
  * business_id (PK)
  * address
  * city
  * state
  * country
  * lat
  * long
* **Geo index table**: (geohash to business_id residing in that geohash)
  * geohash (PK)
  * business_id

### High-level design (first version)

![](/resources/IMG_5313.jpg)

* Two main components:
  * Location Based service (LBS)
  * Business service


### Algorithm to fetch nearby businesses

* **geohash**
  * More granularity with increasing length of geohash; 4 to 6 is good for us.
  * Geohashing guarantees longer shared prefix grids are closer to each other.
  * Grids are static, with well-defined geohash, for example **`9q8zn9`**. 
    * If a given doesn't have sufficient business, we can replace the last 
    character with the nearby grid's last characters, and expand the search.
  * Data is stored in database; for our purpose, RDBMS, like MySQL is good.


* **quadtree**
  * Recursively split region into smaller quadrants, until # of businesses in each
  quadrant is not equal to minimum limit, say 100.
  * This data structure is in memory:
    * Data on leaf nodes:
      * top left and right bottom coordinates for each grid: 32 bytes (8x4)
      * list of business_ids in the grid: 8 bytes * 100 
      * Total: 832 bytes
    * Data on internal nodes:
      * top left and right bottom coordinates for each grid: 32 bytes (8x4)
      * pointers to 4 children: 32 bytes (8x4)
      * Total: 64 bytes
    * **Memory needed**:
      * each grid max of 100 businesses
      * number of leaf nodes: 200 million / 100 = 2 million
      * number of internal nodes: 2 million * 1/3 = 0.67 million
      * Total memory = (2 million * 832 bytes) + (0.67 million * 64 bytes) = 1.71 GB


* Operational considerations for quadtree:
  * Service startup: 
    * Few minutes to build in-memory quadtree at server startup.
    * To avoid service downtime, incremental server startup can be deployed.
  * Add or remove businesses:
   * Need to rebuild the quadtree; can be done incrementally.
   * Can be executed as a part of nightly job.


### Design Deep Dive:

#### Scale the database:
* Business table:
  * Shard by business Id
* Geospatial index table:
  * No need to shard, as data can be stored in a single db server.
  * Replicate the db as per need across multiple availability zones.

#### Caching:
* Business table:
  * cache key : business_id
  * cache value: business_object
* Geospatial index table:
  * cache key : geohash
  * cache value: list of business_ids in the grid.


### High-level design (revised version)

![](/resources/IMG_5315.jpg)

   
