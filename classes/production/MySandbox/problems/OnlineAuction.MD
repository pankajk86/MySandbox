## Online auction

### Functional requirements:
1. User can create an auction.
2. User can place a bid.
3. User who have placed a bid, can change their bid price.
4. The system should inform user in near real time, if their bid has been overbid.
5. The system should close the bid
   * close at fixed time (1 week from start).
   * close when no new bid coming in 1 hour (highest bidder wins).


### Non-functional requirements:

1. Very low latency about the bid update.
2. Highly available.
3. Highly Consistent.
4. Highly reliable.
5. Highly scalable.
6. Read >> write (more users will check the bid, than placing the bid).


### Back-of-the-envelope estimates:

* Auction: 10^4 live actions at any second.
* No. of bidders per auction: 100.
  * Avg. # of bids per user per auction: 5
* Write QPS: 1 bid / second: 10^4 QPS
  * Peak QPS : 3 * normal write QPS : 3 * 10^4
* Read QPS: 1000 * write QPS = 10^7.
* Peak QPS : 3 * normal read QPS = 3 * 10^7

### Core entities:

1. Auction
2. Bid
3. User
4. Item

### API Design:

* `POST /v1/auction/create`
  * Request : item_id, base_price
  * Response: auction_id, HTTP 200
* `POST /v1/bid/initiate`
  * Request : auction_id, max_bid_amount
  * Response : 200
* `POST /v1/bid/raise`
  * Request : auction_id, new_max_bid_amount
  * Response : 200
* `GET /v1/auction/status?{auctionId}`
    - Response: auction_id, status, current_leader_id
    - Will handle over SSE

### High Level Design: (** refer to dive deep diagram **)

![](/resources/IMG_5346.png)

* AuctionService:
  * creation and closing of an auction.
  * Tracks the progress of an auction by subscribing to the auction topic.
* BiddingService:
  * Handles new or updates on existing bids.
  * Sends status updates to Auction owner and bidders over SSE.
    * Reason for SSE over web-sockets:
      * Not all bidders will be posting new bids.
      * Most of them are viewers, hence dont need two-way communication, like websocket.
  * Publishes new bid events to auction specific topics.
* Choice of Database:
    * Ongoing auctions: DynamoDB 
      * Low latency updates.
* Pub / sub: Redis pub / sub
  * Pros : 
    * Realtime update to clients.
    * Can use sorted set to order the bids by descending order of bid amounts.


### Dive deep:

![](/resources/IMG_5347.png)

* Realtime message service (RMS)
  * Dedicated service subscribed to specific auction topic, and sends updates to users over SSE.
* AuctionTransitionService
  * Service to keep track of:
    * the auction status
    * Bids on the auction, and compare with rules of termination.
    * Calls AuctionService to close the auction, once the rules are satisfied.
* RuleService:
  * Dedicate service to maintaining various rules related to:
    * Termination of an auction.
    * Other rules.
  * Can have a cache in front of it, which ActionTransitionService can invoke before calling the service.

