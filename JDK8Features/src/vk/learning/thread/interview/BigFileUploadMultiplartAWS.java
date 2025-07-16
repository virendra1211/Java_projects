package vk.learning.thread.interview;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.synth.Region;

import org.springframework.web.bind.annotation.RequestBody;

import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.CompletedPart;
import software.amazon.awssdk.services.s3.model.CreateMultipartUploadRequest;
import software.amazon.awssdk.services.s3.model.CreateMultipartUploadResponse;
import software.amazon.awssdk.services.s3.model.UploadPartRequest;
import software.amazon.awssdk.services.s3.model.UploadPartResponse;

/*
Step 1: 
	Add AWS SDK to Your Project
Step 2: Configure the S3 Client
	Set up an Amazon S3 client using your AWS credentials and region. This client will be used to initiate uploads and send file parts
Step 3: Start a Multipart Upload
	Start a multipart upload session by making a request to S3. S3 will return an upload ID which is required to upload the file in parts.

Step 4: Read the Large File in Chunks
	1 Instead of loading the entire file into memory:
	2 Open the file as a stream.
	3 Read it in fixed-size chunks (e.g., 10 MB or more).
	4 Keep track of the current file position.
	
Step 5: Upload Each Chunk to S3
	For each chunk read:
	Upload it to S3 as one "part" of the multipart upload.
	Keep track of the part number and the ETag returned by S3.
Step 6: Complete the Multipart Upload
	After all parts are uploaded:
	Send a request to S3 to finalize (complete) the multipart upload.
	Provide the list of all uploaded parts and their ETags.	
Step 7(Optional) : Handle Errors
If something goes wrong during upload:
	Use the upload ID to abort the multipart upload.
	This ensures incomplete data is cleaned up in S3.

Note:
	Minimum chunk size: 5 MB (except the last part).
	You can upload up to 10,000 parts per file.
	Chunks can be uploaded sequentially or in parallel (for better performance).

✅ What is an ETag in Amazon S3?
ETag (short for Entity Tag) is a unique identifier assigned by Amazon S3 to each object (or part) when it is uploaded.
📌 Purpose of ETag
	It helps identify a specific version of a file.
	Used to verify data integrity (like a checksum).
	Especially important in multipart uploads to ensure each part was uploaded correctly.


 */
public class BigFileUploadMultiplartAWS {
	public static void main(String[] args) {
		String bucketName = "s3://";
		CreateMultipartUploadRequest createRequest = CreateMultipartUploadRequest.builder()
				.bucket(bucketName).key(key).build();

		CreateMultipartUploadResponse response = s3.createMultipartUpload(createRequest);
		String uploadId = response.uploadId();
	}

	public void readAndUploadEachchunk() {
		List<CompletedPart> completedParts = new ArrayList<>();
		long fileLength = file.length();
		int partSize = 10 * 1024 * 1024; // 10MB
		int partNumber = 1;

		for (long position = 0; position < fileLength; position += partSize) {
			InputStream chunkStream = getChunkInputStream(file, position, partSize);

			UploadPartRequest uploadPartRequest = UploadPartRequest.builder().bucket(bucketName)
					.key(key).uploadId(uploadId).partNumber(partNumber)
					.contentLength(chunkStream.available()).build();

			UploadPartResponse uploadPartResponse = s3.uploadPart(uploadPartRequest,
					RequestBody.fromInputStream(chunkStream, chunkStream.available()));

			completedParts.add(CompletedPart.builder().partNumber(partNumber)
					.eTag(uploadPartResponse.eTag()).build());

			partNumber++;
			chunkStream.close();
		}

	}

	// Use BufferedInputStream to read a file in fixed-size chunks:
	public InputStream getChunkInputStream(File file, long start, int size) throws IOException {
		RandomAccessFile raf = new RandomAccessFile(file, "r");
		raf.seek(start);
		byte[] buffer = new byte[size];
		int bytesRead = raf.read(buffer);
		raf.close();
		return new ByteArrayInputStream(buffer, 0, bytesRead);
	}

	// @Bean
	public S3Client s3Client() {
		return S3Client.builder().region(Region.US_EAST_1)
				.credentialsProvider(ProfileCredentialsProvider.create()) // or use env vars
				.build();
	}
}
