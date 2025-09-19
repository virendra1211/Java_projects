package vk.learning.important.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

/*
 * Multiple ways like 
 * ByteBased
 * InputStrea, outputStream
 * or Read, Writer
 */
public class BigCSVFileRead1 {
	public static void main(String[] args) {

	}

	public static void executProductIds(List<Long> productIds) {
		List<List<Long>> batches = splitIntoBatches(productIds, 50);

		ExecutorService executor = Executors.newCachedThreadPool();
		List<CompletableFuture<Void>> futures = batches.stream()
				.map(batch -> CompletableFuture.runAsync(() -> processBatches(batch), executor))
				.collect(Collectors.toList());

		// wait for all future to complete
		CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

	}

	public static void processBatches(List<Long> batch) {
		batch.forEach(BigCSVFileRead::fetchUpdateAndPublish);
	}

	private static void fetchUpdateAndPublish(Long productId) {
		Product product = repository.findById(productId)
				.orElseThrow(() -> new IllegalArgumentException("productId does not exist"));
	}

	private static List<List<Long>> splitIntoBatches(List<Long> productIds, int batchSize) {
		int totalSize = productIds.size();
		int batchNums = (totalSize + batchSize - 1) / batchSize;

		List<List<Long>> batches = new ArrayList<>();

		for (int i = 0; i < batchNums; i++) {
			int start = i * batchSize;
			int end = Math.min(totalSize, (i + 1) * batchSize);
			batches.add(productIds.subList(start, end));
		}

		return batches;
	}

}
/*
 * Problem: 1. will face lot of issue if we are reading whole file,
 * 
 * 
 * Solution: 1. we should go for BufferReader, line by line or chunk by chunk,
 * 2. there will be no memory issue at all. 3. instead of reading from stream
 * read from the buffer. 4.
 * 
 */
