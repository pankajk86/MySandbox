## Chat System

### Functional requirements:
1. System should support both 1:1 and group chat.
2. System should indicate if a user is online or offline.
3. If a user is offline, message should be stored in service side for delivery in the future, when user is online. 
4. Chat history should be stored forever.
5. System should support only text messages.
6. System should push notifications.

### Non-functional requirements:
1. Low delivery latency
2. Multiple device support.


### Back-of-the-envelope estimation:

bytes * 10^3 = KB * 10^3 = MB * 10^3 = GB * 10^3 = TB * 10^3 = PB

* DAU: 100 million
* Group: 100 people
* Text length: 500 characters (500 bytes, including metadata)
* Number of messages: 100 per user per day
* Storage: 
  * 100 million * 100 (messages) * 500 bytes = 100 * 10^6 * 5* 10^4 bytes = 5 TB per day
  * 5 TB * 400 = ~2 PB per year.


### Database schema:

* **chat_members** - all chats which user x is part of.
  * DB to use: MySQL (or any other RDBMS)
  * Pros:
    * Consistency to avoid causal dependency write conflict of adding and removing user from a chat.
    * Single leader replication will help in that.
  * schema:
    * user_id (partition_key, index)
    * chat_id
* **users** - information about users.
  * DB to use: MySQL (or any other RDBMS)
  * schema:
    * user_id (partition_key, index)
    * email
    * password_hash
* **Message tables** - stores chat messages
  * DB to use: Cassandra (or HBase? - it uses single leader replication with LSM tree)
  * Pros:
    * LSM Tree index, leader-less replication 
    * read and write (care about write more) should be fast.
    * messages are in the same partition and already sorted by timestamp.
  * **messages** - 1:1 messages
    * schema:
      * message_id
      * chat_id (partition_key)
      * timestamp (cluster_key)
      * message
      * from_id
      * to_id
      * metadata
  * **group_chats** group chat messages
    * schema:
      * chat_id (partition_key)
      * message_id (partition_key)
      * timestamp (cluster_key)
      * message
      * metadata
* **online_presence** - store user's online presence
  * DB to use: Cassandra
  * schema:
    * user_id (partition_key)
    * status
    * last_active_at

#### MessageId generation strategy:

* Requirements:
  * Ids must be unique.
  * Ids should be sortable by time, i.e. newer rows have higher value that older ones.
* We can use local sequence number generator, i.e. ids unique within a group or in 1:1 chat.
* Ordering in one chat is sufficient.


### Deep dive design

* Bidirectional connection b/w chat server (CS) and user device using **web sockets**.

* **Service Discovery**

![](/resources/IMG_5320.png)

* ZooKeeper:
  * Coordination service
  * Strongly consistent, based on consistent hashing ring.
  * works kind of : f(user_id) -> chat_server_id
* Multiple load balancers (active-active mode) can be connected to ZooKeeper.

* **In case of a chat-server getting offline**:
  * CS sends regular heart-beat to ZooKeeper and the devices connected to it.
  * If ZooKeeper doesn't receive heartbeat after sometime, it updates the consistent hashing function to reassign devices to healthy CSs.
  * LB subscribes to ZooKeeper and get updates for the updated device-Id to CS mapping.
  * Once a device doesn't receive heartbeat after sometime, it checks with LB, and one of the healthy CS is assigned to the device.
  * Different devices are timed out after different threshold to avoid **thundering herd** situation.

* **1:1 Message Flow**

![](/resources/IMG_5321.png)

* Messages are sent to the message_sync_queue. We will use Redis pub / sub.
* If the user is online, the message is routed to the receiver's chat server via LB.
* If the user is offline: 
  * A push notification is sent to push notification (PN) server.
  * Once the user is online, pending messages are flushed to the user.


* **Group chat Flow**

![](/resources/IMG_5322.png)

* For each user, there is a message_sync_queue, which will work as in inbox.
* This queue will receive all the messages for a given user.


* **Online Presence**

* User Login:
  * When user logs in, the presence status is set as online in online_presence table. 
* User logout:
  * When user logs out, the presence status is set as offline in online_presence table.
* User disconnection:
  * Updating user_presence table, every time user is disconnected is not viable.
  * Solution:
    * Online device periodically (say after every 5 seconds) sends heartbeat to the presence server (PS).
    * If PS receives heartbeat within certain time interval (say after every 30 seconds), status is shown as online.
    * Otherwise, status is shown as offline.

* **Fanout online status**

![](/resources/IMG_5323.png)

* PS use pub-sub model - each friend pair maintains a channel.
* User online status is broadcast to it's channel. All users subscribed to this channel, will receive the status update.
* This communication b/w client and PS is executed over web socket.
