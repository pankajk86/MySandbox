## Tinder

### Functional requirements:

1. Users can specify filters for match preference, like age, interests, location.
2. Users can swipe right / left to express "yes" / "no" for another user.
3. If two users mutually express "yes", notifications will be sent to them.

- Matched users can DM each other.
- Users can upload pictures.

### Non-functional requirements:

1. There should be 0 latency when presenting user profiles to a user.
2. The system should be highly available as compared to consistent.
3. The system should scale to large user base (20M DAU), with hundreds of swipe per user per day.
4. User should not be shown profiles which he had already seen.

- Protection against fake profiles.

### Core entities

* Users - swiping_user, and target_user
* Swipe - action of expression "yes" or "no".
* Match - two users mutually express "yes" to each other.

### APIs

* `GET /feed`
  * Request: lat, long, distance
  * Response: List<Users>
* `POST /swipe/{targetUserId}`
  * Request: decision (yes / no)


### High level design

![](/resources/IMG_5335.png)

* Efficient feed creation for users
  * We build a **user feed cache** that is generated offline.
  * This cache will be generated off a **user index**, which takes various aspects into account:
    * Change data capture (CDC) from the user database.
    * It will apply geospatial queries based on geohash, or quadtree.
    * Additional ML models can be leveraged to tune the ranking of the user profiles in the user feed cache.
  * **Challenge**
    * The DB should be partitioned on location, to keep the density for each shard uniform.
    * It will also need some business logic to refresh the cache.
* User swipes right / left for "yes" / "no".
  * Action will store the result in the Swipe DB table.
  * Choice of DB - Cassandra
    * Write heavy operations (based on Memtables, and SSTable).
  * Partition on swiping_user_id. 
  * **Challenge**
    * Cassandra, being a NoSQL DB, causes eventual consistency.
      * This may be result is missing swipes.
* Mutually matched users are sent notifications. 
  * Check in the swipe DB table, if the swiping_user_id and target_user_id has swiped each other.
  * If so, update match DB table.
  * Invoke notification service, which will send notification to users.


### Dive deep

![](/resources/IMG_5336.png)

* Avoid stale feeds
  * We can set a TTL for the cache (like 6 hours), after which the cache will be refreshed from the user index.
  * It is a compute heavy operation, so we can refresh cache only for very active users (we can come up with parameters).
* Avoid showing profiles, which user has already viewed.
  * Maintain a cache on the client side.
    * It will keep track of the profiles, that the user has viewed recently.
    * Out of the initially loaded profile from the user feed cache, this client side cache will filter the profiles, which user has already viewed.
    * For subsequent fetch from the user feed cache (suppose initially 200 profiles were fetched, and user has viewed 150), client cache will ensure that only unseen profile are surfaced to the user.
* Ensure reliable match creation:
  * Since we are using Cassandra for swipe DB table, we have eventual consistency.
    * There may be "yes" swipes which may not have propagated to all partitions.
    * This may result in missed matches.
    * **Solution**
      * Until all the partitions are updated with the "yes" swipe response for a given user, we cache it.
      * This cache will be only for "yes", as that swipe has chance of ending up in match.
      * We will store "yes" swipes  in a cache partitioned by `swiping_user_id`.