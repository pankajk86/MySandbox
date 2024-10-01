## Uber

### Functional requirements:
1. User should be able to search for rides between two locations, and fare.
2. User should be able to request a ride.
3. Drivers should be able to accept / deny request.

- Scheduling rides in advance.
- Ratings for drivers and users.
- Different types of rides.

### Non-functional requirements:
1. No double booking for rides.
2. High throughput during peak hours.
3. Low latency in matching riders to drivers.

- Fault tolerant
- Monitoring

### Back-of-the-envelope estimation:

bytes * 10^3 = KB * 10^3 = MB * 10^3 = GB * 10^3 = TB * 10^3 = PB

### Database schema and core entities

* Choice of DB - MySQL (strong consistency)
* **riders** - rider details
  * schema:
      * rider_id
      * payment_id
* **drivers** - driver details
  * schema:
    * driver_id
    * vehicle_id
    * status - in_ride, offline, available
* **routes** - route and fare details b/w source and destination
  * instead of storing into own DB table, can leverage third party services.
  * we will add additional surcharges to fare estimates.
  * we can cache it as per need.
* **ride** - ride details
  * schema:
    * rider_id
    * driver_id
    * fare_estimate
    * eta
    * source_location_id
    * destination_location_id
    * status

* Choice of DB - Cassandra (Write heavy), or Redis
* **location** - location of the driver
  * location_id
  * geohash_id
  * driver_id
  * lat
  * long

### API design
* user_id or driver_id, and authentication details will be in the header.
* `POST /v1/ride/fare : List<Ride>` - search for rides.
  * Request: 
    * source_location_id
    * destination_location_id
  * Response:
    * route_details   :  based on 3rd party `routes` service call result. 
    * fare_amount
* `POST /v1/ride/request` - request for ride
  * Request:
    * ride_id
  * Response: 200 / 204
* `POST /v1/location/update` - updates driver's current location
  * Request:
    * lat
    * long
  * Response: 200 / 204
* `POST /v1/ride/driver/accept` - process driver's response to rider's request
  * Request:
    * ride_id
    * has_accepted
* `POST /v1/ride/driver/status` - status update for driver
  * Request:
    * ride_id
    * status
  * Response: lat/long (if status is in `in progress`), or null (if status is `completed`)

### High level design

![](/resources/IMG_5326.png)

* Three microservices to handle requests.
* Separate DB for main ride related data, and driver's location data.
* Get fare flow:
  * submits the request with source and target location.
  * Ride service makes call to 3rd party mapping API to calculate the distance and fare.
  * Ride service creates fare entity in the DB, and returns the object to rider as response.
* Ride matching flow:
  * Once user accepts fare, Ride Service calls Ride matching service to match the rider with nearby driver.
  * Drivers keep updating their location by LocationService.
    * ElasticSearch can be used as the DB for geospatial update and query.
  * Ride matching service sends notification to the nearby driver.
  * If driver accepts, the matching is complete.


### Deep dive:

![](/resources/IMG_5327.png)

* **Distributed lock for reserving a ride**.
  * We can use Redis as distributed lock.
  * Lock for a configurable time, say 1 minute.
    * If the driver doesn't receive the request by then, driver will be made available for other rides.
    * Rider will be routed to other drivers.
* `RideMatchingService` can incorporate different algorithms to select drivers.
  * K-nearest, and start with the nearest one.
* **Location storage in geo_hash index**.
  * Better to use write efficient DB, like Cassandra.
  * We can use geohash for storing the current location.
    * Range based query will be efficient, with geohash as the cluster_key.
    * Closer geo-hashes mean closer locations.
* Location update for drivers in `LocationService`:
  * **Use ElasticSearch** to store driver's location update.
      * ElasticSearch has in-build support for geo-spatial indexing and query.
      * It is scalable and durable.
      * Redis can be another option, but ElasticSearch has more comprehensive support for geospatial features.
    * Other option to reduce latency of constant update can be to use batch update.
      * Problem: Delayed updates may cause inconsistency in finding out nearby drivers.
  * **Web sockets between riders (and drivers) and server**.
    * HTTP requests for sending (or receiving) location update can be OK. but need to send headers with every request.
    * Web sockets are bidirectional, and being stateful will make communication efficient.
  * We can have sophisticated approaches about the frequency of the status update.
* **Caching (redis)**
  * For peak traffic, we can cache rides. 
    * This will save API call cost, if using 3rd party services.
  * We can cache drivers location update as well.
    * Though using Cassandra, we can still cache their location in cache.
    * Partition cache by geohash_id.
    * Write to DB in batches in large time interval, rather than 3-5 seconds.
* **Message Queue (for RideMatchingService)**
  * Queue can be partitioned by geo_hash_id for even distribution of request.
  * Helpful to server peak traffic.
