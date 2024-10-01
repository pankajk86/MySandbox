## Load Balancing

### Introduction

* Load balancing is the method of distributing network traffic equally across a pool of resources that support an application.
* To handle such high volumes of traffic, most applications have many resource servers with duplicate data between them. 
* A load balancer is a device that sits between the user and the server group and acts as an invisible facilitator, ensuring that all resource servers are used equally.

### Benefits

* Application availability
  * Run application server maintenance or upgrades without application downtime
  * Perform health checks and prevent issues that can cause downtime
* Application scalability
  * Prevents traffic bottlenecks at any one server.
  * Predicts application traffic so that you can add or remove different servers, if needed.
* Application security
  * Deal with distributed denial of service attacks, by use of Rate limiter.
  * Monitor traffic and block malicious content
* Application performance
  * Distribute the load evenly between servers to improve application performance.
  * Redirect client requests to a geographically closer server to reduce latency.


### Load balancing algorithms

#### Static load balancing

###### Round-robin method
* Requests are routed to the registered hosts in round-robin manner.

###### Weighted round-robin method
* We assign different weights to each server based on their priority or capacity. 
* Servers with higher weights will receive more incoming application traffic from the name server.

###### IP hash method
* The load balancer performs a mathematical computation, called hashing, on the client IP address. 
* It converts the client IP address to a number, which is then mapped to individual servers.

#### Dynamic load balancing

###### Least connection method
* The load balancer checks which servers have the fewest active connections and sends traffic to those servers.
* This method assumes that all connections require equal processing power for all servers.

###### Weighted least connection method
* We assign different weights or capacities to each server. 
* The load balancer sends the new client requests to the server with the least connections by capacity.
* This method assumes that some servers can handle more active connections than others.

###### Least response time method
* This method combines the server response time and the active connections to determine the best server. 
* This method is used to ensure faster service to all users.

###### Resource-based method
* The load balancers distribute traffic by analyzing the current server load.
* Specialized software called an agent runs on each server and calculates usage of server resources, such as its computing capacity and memory.
