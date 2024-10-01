## Code Judge (LeetCode)

### Functional requirements:
1. Users should be able to list problems.
2. Users should be able see the details of a problem.
3. Users should be able to submit solutions in their choice of programming language.

### Non-functional requirements:
1. Users can see their ranking and submission details.
2. The system should make sure that user's code does not compromise the service.
3. The system should be scalable to support peak traffics, like competitions.
   * Is the peak traffic deterministic?
4. The system should be highly available, even when during peak traffic the load on the service will be CPU intensive.


### Core Entities:

* Problem - problem statement, test cases, expected output.
* Submission - User's code string, programming language.


### API design:

* `GET /problems?page=1&limit=100 -> List<problem>`
* `GET /problems/{id} -> problem`
* `POST /problems/{id}/submit -> submission`
  * Request body: code string, programming language

### High level design

![](/resources/IMG_5333.png)

* Execute the user's code in runtime specific Docker containers.
  * It isolates the platform environment from the environment executing user's code.
  * This prevents the platform from running malicious codes, if a user submits intentionally or unintentionally.
  * **AWS Lambda** - We can also run user's code as a serverless function.
    * But this approach has a cold start for the initial request.
    * Additional latency is not expected by the system.
* The flow is as follows:
  * User submits the request to server.
  * Server sends the requests to the appropriate runtime docker container.
  * Once executed, the container sends the request to the server, which stores the result in DB.

### Deep dive

![](/resources/IMG_5334.png)

* System isolation and security when running user's code:
  * **Read only file system**:
    * Mount user's code to read only file system.
    * Any write is done to a temporary location, which is cleaned after execution.
  * **Explicit Timeout**:
    * Service will define explicit timeout (like 5 seconds) for the execution of a problem.
    * Beyond the threshold, the problem will be failed.
  * **CPU and memory limit**:
    * We can set CPU and memory limit for each of the runtime container.
    * If these limits are exceeded, the container is killed.
    * New runtime containers are spawned to serve other submissions.
  * **No System or over the network calls**:
    * Necessary configurations can be made in the docker containers to prevent users from executing system or over the network calls.

* Scale system to serve peak traffic, like competition:
  * Scale horizontally by incorporating a queue mechanism, like SQS.
  * Flow will look as follows:
    * User submits their submission.
    * Submission is added to the queue.
    * To check the status of their submission, two approaches are possible:
      * Web socket - bidirectional, and client will be notified of the updated status, once processed by server.
      * **Long polling** - client can poll after certain interval, say 1 second, to check the status.
    * Once the status is available, client updates it accordingly.
    * Which time to pick:
      * Submission time - client time, or time when the request was added to the queue.
      * Time taken to execute the code - it will be evaluated in the container when it starts and end the execution of the code against all test cases.

* Maintain and run test cases against different programming languages:
  * Store the test cases (input, and expected output) in a language agnostic serialized format.
  * Once a submission needs to be processed:
    * The input and expected output is deserialized as per the programming language.
    * User's code is executed with the input.
    * User's output is compared against the expected output.