## Async Message Queue Systems

### Introduction

Async message queues are used to:
* Decouple two components of a systems, ideally a producer and a consumer.
* Parallel processing can be executed by these two (or more) components.
* Number of producers and consumers can be configured to increase throughput.


### Popular Message Queues

#### AWS SQS

* **Types of Queues**
  * Standard:
    * Best effort queueing
    * At least once delivery
    * Unlimited throughput
  * FIFO:
    * First In First Out queueing
    * Exactly once delivery
    * Max 300 TPS
    * Expansive than Standard
* **Visibility Timeout**
  * Built-in support to retry a failed processing of a message after this timeout.
  * It can be configured.
* **Maximum message size**
  * 256 KB
* **Dead Letter Queue (DLQ)**
  * A separate queue, configured to store messages, which were not processed successfully.