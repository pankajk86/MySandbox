## Game Leaderboard

### Functional requirements:
* When a player wins a game, his score needs to be updated.
* The system should show top 10 players with their scores.
* The system should return the rank of a given player, when queried, if not in top 10.

### Non-functional requirements:
* The leaderboard update should be near real-time (NRT).
* The system should have low latency for the read and write operations.
* The system should be scalable to accommodate large number of players.


### Core Entities:

* user (user_id, display_name, etc.)
* game_leaderboard (game_id, user_id, score)

### API design

* `POST /v1/score` - update the score, when a user wins a game.  
  * Request - game
  * Response - 200
* `GET /v1/leaders` - get top 10 players and scores.
  * Request - no body
  * Response: 
    * [{"game_id": "", ""user_id": "", "score": }]
* `GET /v1/users/{userId}` - get rank and score for given userId
  * Request = no body
  * Response: [{"game_id": "", ""user_id": "", "score": }]

### High Level design

![](/resources/IMG_5340.png)

* GameService to receive updates from clients.
  * Validates the user's score for the game and updates the database.
* LeaderBoard service for serving top 10 players and user specific queries.
* Choice of database : Redis
  * We can leverage Sorted Set data structure to serve our purpose.

### Deep Dive

![](/resources/IMG_5341.png)