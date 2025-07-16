package vk.learning.thread.interview;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

// File read from CSV 10 GB or 1 gb file ,, first identified which reader shold we go
/*
 * First donw we can't read the entire csv file, we can't load the 10 gb of
 * data to the stream, its not at all possible will get go for Buffer Reader
 * line by line or chunk by chunk we are reading , Advantage of buffer reader, 
 * it's reading the data from 
 * the buffer instead of directly from the file
 */
public class BigFileReadMostInterviewQuestion {

	// Simple and ave Optiaon

	public static void main(String[] args) {
		// Two type reader
		/*
		 * 1. Byte Based reader use -> InputStream or OutputStream 2. Character based
		 * reader -> Reader and Writer used Ify you want you can go with the Buffer
		 * increased size
		 */
		try {
			readLargeCSV("abc.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void readLargeCSV(String fileName) throws IOException {
		File file = new File(fileName);
		FileReader reader = new FileReader(file);
		BufferedReader br = new BufferedReader(reader);
		String line;
		while ((line = br.readLine()) != null) {
			String[] columns = line.split(",");
			for (String column : columns) {
				System.out.println(column);
			}

		}

	}

	private static void generateCSV() throws IOException {
		FileWriter csvWriter = new FileWriter("src/sells.csv");

	}

	// Option 1 simple and safe
	public void readFileInChunks(File file, int chunkSizeMB) throws IOException {
		int chunkSize = chunkSizeMB * 1024 * 1024; // Convert MB to bytes
		byte[] buffer = new byte[chunkSize];

		try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file))) {
			int bytesRead;
			int part = 1;

			while ((bytesRead = bis.read(buffer)) != -1) {
				byte[] chunk = Arrays.copyOf(buffer, bytesRead);
				System.out.println("Read part " + part + ", size: " + bytesRead + " bytes");

				// For example, upload chunk to S3 or process
				// uploadChunkToS3(chunk, part);
				part++;
			}
		}
	}

}
