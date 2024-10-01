## Ticket Master

### Functional requirements:
1. View event details
2. Search for events
3. Book events
4. New events can be added (P1)

### Non-functional Requirements:
1. Strong consistency in booking, i.e. no double booking.
2. Scalable for high throughput, especially for popular events.
3. Read (view and book events) >> write (add new events).

### Back-of-the-envelope estimation:
bytes * 10^3 = KB * 10^3 = MB * 10^3 = GB * 10^3 = TB * 10^3 = PB

### Database schema:

* Choice of DB - MySQL (strong consistency)
* **event** - event details
  * schema:
    * event_id
    * performer_id[]
    * venue_id
* **venue** - venue details
  * schema:
    * venue_id
    * name
    * location
    * seat_id[]
* **performer** - performer details
  * schema
    * performer_id
    * name
* **ticket** - ticket details
  * schema:
    * ticket_id
    * booking_id
    * price
* **user** - user details
  * schema:
    * user_id
    * name
* **seat** - seat details
  * schema:
    * seat_id
    * venue_id
    * section_id
* **booking** - booking details
  * schema
    * booking_id
    * user_id
    * ticket_id
    * event_id
    * seat_id

### API design
* **user_id and other authentication details will be in header**.
* `GET /v1/events/search?filters=venue|time_range|performers` - search for events
* Response:
  * List of events
* `GET /v1/events/?id={event_id}` - get event details
  * Response:
    * event_id
    * event_name,
    * description
    * venue
    * performers
* `POST /v1/booking/reserve` - reserve the seat for booking
  * Request:
    * event_id
    * seat_id
* `POST /v1/booking/confirm` - payment and confirm booking
  * Request:
    * event_id
    * seat_id
    * payment_info
  * Response:
    * confirmation_number
    * event_details
    * check_in_details

### High-level design:

![](/resources/IMG_5324.png)

* Choice of DB: MySQL
  * Not very frequent write (event creation).
  * Strong consistency requirement.
* **Use ElasticSearch for search operation.**
  * We can have offline scheduled jobs to process change data capture (cdc) to ES.
  * Later on we can build more sophisticated search system.
* 3rd party payment service providers (PSP) to handle payments.

### Deep Dive: (Check notes)

![](/resources/IMG_5325.png)

* Distributed lock (with Redis) to get hold of booking ticket.
  * With `/v1/booking/reserve`, the user will acquire a lock on the ticket.
  * This lock will have a TTL associated with it, like 7-10 minutes.
  * If the booking is complete within TTL, the ticket will be updated as booked.
  * Otherwise, the ticket will be made available for others.
* Other option for locking and unlocking a ticket:
  * Have a cron job to check the ticket's status after regular interval.
  * Problem : Delayed response, when reservation actually expired, and when cron job unlocked it.

* We can utilize CDNs to cache search results geographically closer to the users. 
* **Use Message Queue to decouple writes to DB**
  * Booking throughput will be increased.
  * It will be helpful during peak traffic for queueing the requests as needed.
* **Waiting Queue for users for popular show booking**
  * We can leverage web sockets b/w client and server.
  * Regular update to clients after certain interval about the wait status.
  * We can also reduce the TTL for distributed lock to allow less wait time for users.
  * Other option is to have **SSE sent to clients with realtime seat updates**.
    * User experience may not be great, as for popular events, as seat may be filled up instantly.
* **Scale for peak traffic**:
  * Load testing with expected QPS traffic.
  * Scale # of hosts for the three services accordingly.