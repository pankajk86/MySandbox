## Dropbox / Google Drive

### Functional requirements:

1. Upload a file from local device.
2. Download file to local device.
3. Sync files across multiple devices.
4. Share file with other users, and view shared files.

- View file without downloading.
- Edit files.


### Non-functional requirements:

1. Highly available (it's ok to not see recently uploaded file for some time).
2. Large files can be uploaded, like 10 GB.
   * Resumable uploads
3. The system should be secure, i.e. no file corruption, or deletion.
4. Sync accuracy should be high.
5. Low latency for upload and download files.

- Versioning of the files.
- Storage limit per user.

### Back-of-the-envelope estimation:

bytes * 10^3 = KB * 10^3 = MB * 10^3 = GB * 10^3 = TB * 10^3 = PB


### Database schema and core entities:

* Blob storage (S3)
  * **File** - raw data uploaded by user.

* DB Tables:
  * **file_metadata** - metadata about the file.
    * schema:
      * file_id
      * name
      * uploaded_by
      * chunks // will come to this later
  * **file_chunks** - chunks info about a file.
    * schema:
      * chunk_id
      * file_id
      * status
  * **users** - users info
    * schema:
      * user_id
  * **file_shared** - file shared info
    * schema:
      * user_id
      * file_id

### API design:

* `POST /files/presigned-url` - get pre-signed URL to directly upload file to S3.
  * Request: 
    * file_metadata
  * Response:
    * S3 pre-signed URL

* `GET /files/{fileId}` - download file
  * Response:
    * file
    * file_metadata

* `GET /changes?since=timestamp` -> fileIds[]

* `POST /files/share`
  * Request:
    * file_id
    * user_id[]
  * Response:
    * 200 / 40* / 50*

* `GET /files` - get all files shared with the current user.
  * Request
    * None
  * Response:
    * file[]
    * file_metadata[]

### High-level design:

![](/resources/IMG_5350.png)

* Client (uploader) will upload to S3.
  * It will get the pre-signed URL from FileService, and upload the file directly to S3.

* Sync between local and remote:
  * Remote changes:
    - pull the changes
    - apply locally
    * Approach:
      - local DB in client will store the local file metadata.
      - we can have a polling mechanism at regular interval to check any remote changes.
      - when pulling changes from remote, will compare with local.
      - if remote has a new timestamp, download from remote.

  * Local changes:
    - upload the changes
    * Approach:
      - OS based API call to detect changes
      - if changes detected, execute the /upload flow.
  
* Cache files in CDN for efficient download.


### Deep dive:

![](/resources/IMG_5351.png)

#### Large Files
* Chunk file at client side before uploading to S3.
  * Efficient upload and resilient to network failure.
  * Parallel upload.
  * Only upload changed chunk(s), if a file is updated.
  * It will help the client application to track how far the file upload has progressed.
  * In case of failure, due to network failure, upload can be resumed from the last uploaded chunk.
  * Identify which chunks have been uploaded:
    * we can use id - not efficient and error-prone.
    * RECOMMENDED:
      - hash(chunk of the bytes) -> fingerprint.
      - use this fingerprint as chunk_id
* S3 event notification or SNS notifications:
  * In order to maintain the sync b/w file chunks in S3, and file_metadata in DB table.
  * Once a chunk is uploaded successfully, notification will be received by FileService.

#### Low latency for upload and download
* Compression before uploading, and de-compression after uploading in S3.
  * Or we can rely on client to de-compress it after downloading.
  * Be mindful of compression algorithms, and different file formats provide different results.
    * Trade-off b/w time spent in compression vs time saved by it.

#### Security
* Encryption:
  * Chunk level encryption when uploading or downloading.
  * Encryption in S3.
  * During sharing, we can also enforce different level of access control:
    * read, write, admin, etc.