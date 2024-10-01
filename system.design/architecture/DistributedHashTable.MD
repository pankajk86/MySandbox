## Distributed Hash Table

### Introduction

* A distributed Hash Table (DHT), similar to DynamoDB or Cassandra stores the key values in a distributed system.

### Functional Requirements
* It should be able to write and read key value pairs efficiently.

### Non functional requirements:
* The system should be highly available.
* The system should support eventual consistency.
* The system should be scalable and tolerate to any partition failures.
* The availability / consistency can be configured depending on the use case.


### High level design

![](/resources/IMG_5337.png)

* Using consistent hashing to define which nodes (servers) will store which data.
  * Both servers and keys are hashed with the same hash function.
  * The range used to execute mod (%) operation is predefined.

![](/resources/IMG_5338.png)

* In order to configure and enable consistency, we use a centralized coordinator.
  * Factors to consider:
    * N : Number of replicas (usually 3)
    * W : Write quorum. # of ACK from W replicas in order for a given write operation to be successful.
    * r : Read quorum. # of ACK from R replicas in order for a given read operation to be successful.
* For **read optimized DHT**:
  * W : N, R : 1
* For **write optimized DHT**:
  * W : 1, R = N
* For **strongly consistent DHT**:
  * W + R > N

### Failure detection:

![](/resources/IMG_5339.png)

* Gossip protocol is used.
  * Each node maintains a status of subset of nodes.
  * The member nodes keep sending heartbeats after regular intervals.
  * These nodes (maintaining the status) keep sharing the members info with another set of nodes.
  * If a node doesn't receive such heartbeats beyond a certain threshold, they mark that nodes as unavailable, and share the status with other members.
  * Other members also check the status of the presumed unavailable node, and once mark as dead. 



