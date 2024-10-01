## Partitioning

### Introduction:

* Partitions are defined in such a way so that:
    * Each piece of data (a record, row, or document) belongs to exactly one partition.
      * With this, each node can independently execute the query for its own partition. Hence, query throughput increases.
    * One record may belong to multiple partitions in different nodes for fault tolerance.

### Partitioning strategies:

#### Partitioning by Key range

* Sample partitioning:
  * A-C : Node 1
  * D-K : Node 2
  * ...
  * W-Z : Node n
* Pros:
  * Easy to implement.
  * Range query is more efficient.
* Cons:
  * If partitioning is unfair, the load on the nodes may be skewed. Hot spot.
* DB using this approach: 
  * HBase, MongoDB

#### Partitioning by range of Hash of Key

* Steps to follow:
  * Define or use a suitable hash function, say hash(). Also define the hash range.
  * For a given key, calculate hash(key). Use the value to map the key to the node.
* Sample partitioning:
  * 0-10000 : Node 1
  * 10001-20001 : Node 2
  * ...
  * 90001-100000 : Node n
* Pros:
  * Fair distribution of keys among the partitions.
* Cons:
  * Range query is complicated, if at all possible.
* DB using this approach:
  * Riak, Couchbase:
    * Do not support range query.
  * Cassandra: 
    * They do support range query on a given partition.
    * Composite primary key: (partition_key, cluster_key). cluster_key is used to sort the partition_key values.

### Re-balancing strategies:

* Create many more partitions than there are nodes.
* Assign several partitions to each node.
* For example, if there are 10 nodes, create 1000 partitions, so that each node can have 100 partitions.
* When a new node is added:
  * New node will steal a few partitions from each existing node until partitions are evenly distributed.
* When an existing node is removed:
  * Reverse.
* This way, the transferred data to new node is minimized.

### Request Routing

#### Question

* In case of re-balancing, how does a client know where to send an incoming request?
  * This phenomenon is called **service discovery**, and is not limited to database.

#### Solutions

* Use a separate (open source or in-house grown) **distributed coordination service**, like ZooKeeper.
  * ZooKeeper keeps track of cluster metadata by maintaining an authoritative mapping of partitions to nodes.
  * A routing tier, like internal Load Balancer (LB) will subscribe to this information in ZooKeeper.
  * Whenever a partition changes ownership, ZooKeeper notifies the routing tier.
  * Systems using this approach:
    * HBase, Kafka - for tracking partition management.

* Use **Gossip protocol**.
  * Each node maintains a cache of the nodes to partition mapping.
  * This mapping is updated, when a new request arrives and routed to correct node.
    * Sequential, fibonacci or similar traversing happens in order to find the node.
  * Pros:
    * Removes dependency on separate coordination service, like ZooKeeper.
  * Cons:
    * Additional complexity is included in the database nodes.
