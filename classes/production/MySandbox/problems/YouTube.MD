## YouTube / Netflix

### Functional requirements:
1. User should be able to upload videos.
2. User can watch (stream) videos.
3. User can search for videos.

- User can view information about videos, like views, and likes.
- User can subscribe to channels.
- User can see recommended videos.

### Non-functional requirements:
1. The system should be highly available (availability over consistency).
2. The system should scale to address high number of video uploads daily.
3. The system should allow low latency for video streaming.

- validation of videos for bad content.
- Monitoring
- Bots


### Back-of-the-envelope estimation:

bytes * 10^3 = KB * 10^3 = MB * 10^3 = GB * 10^3 = TB * 10^3 = PB

* Number of users: 100 million DAU
* Number of uploads: 10% of users upload 1 video: 10 million per day.
* Average length of the videos: 300 MB
* Number of watched videos: 5 videos per user per day

* Storage: 10 million * 300 MB = 3000 TB = 3 PB per day.
* Read QPS: 100 million * 5 = 500 million / 100K = 5000


### Database schema:

* **users** - user table
  * schema
    * user_id
    * channel_id
* **video**
  * schema
* **video_metadata**

### APIs

**It might change as the design evolves.**

* `POST /upload` - API to upload videos.
  * request : video, video metadata
* `GET /video/{videoId}` - API to read videos.

### High Level design

![](/resources/IMG_5331.png)

* Client will upload the file to S3 directly.
  * More efficient than first client uploads to service, and service uploads to S3.
  * We can offload some responsibilities, like splitting the files, and keeping track of which parts have been uploaded to client.
  * Steps involved:
    * Client splits the file into smaller chunks.
    * It requests the S3 pre-signed URL from the service.
      * S3 pre-signed URL is a temporary available URL to upload files w/o going through authentication path.
    * Client uploads smaller chunks to the S3 pre-signed URL.
    * Once the upload is complete, S3 will merge all parts to make the video file whole.
* Storage of videos after processing
  * Once the storage is complete to S3, event notification will be sent to another video processing service.
  * This service will process and split the video file into smaller segments with different format.
  * The processed video segments will be stored back in S3.
  * The metadata will be updated in video_metadata DB.
* Watching videos using **Adaptive Bit-rate Streaming (ABR)**
  * Instead of streaming entire videos, client will request for video segments.
  * These segments will be fetched based on the device type, available internet bandwidth, etc.
  * Client will be responsible for pulling next segments accordingly, so that to reduce buffer time.

### Dive deep

![](/resources/IMG_5332.png)

* Video processing to support **Adaptive Bit-rate Streaming (ABR)**:
  * Video processing service will maintain and execute an DAG workflow, with responsibilities like:
    * Splitting the video, and processing it with different codecs and containers (to support different clients).
    * Process audio and generate transcripts, if needed.
    * Prepare manifest files for segment look ups.
    * All intermediate results of this workflow will be stored in S3.
* Support for resumable uploads:
  * As mentioned above, client will chunk the video before uploading them.
  * Client will send a request to video service to update video_metadata table about the video, chunks, and upload status.
  * As the chunks are uploaded successfully, the status in the video_metadata table will be set as UPLOADED.
  * If there's any failure:
    * Before retrying, the client will lookup the video_metadata table to check the last successfully uploaded chunk.
    * It will resume uploading the chunks after that.
  * Once all chunks are uploaded, the status of the file will be set as UPLOADED / COMPLETED.
* Scale to support large number of video uploads and watches:
  * We can scale the video service, and  video processing service horizontally.
  * In order to serve read (watching videos), we can deploy CDNs across globe, to reduce latencies.
    * In order to keep the CDN cost low, we can incorporate some caching mechanism (LRU, popular).
  * We can also cache video metadata (may be Redis), in order to reduce DB reads.



