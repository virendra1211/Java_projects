package vk.learning.practice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LargeFileReadAndProcess {

	private static final ExecutorService executor = Executors.newFixedThreadPool(10);

	public static void main(String[] args) {
		// Simulating partition numbers from 1 to 10
		List<Integer> partitions = IntStream.rangeClosed(1, 10).boxed()
				.collect(Collectors.toList());

		Map<Integer, CompletableFuture<String>> futureMap = new HashMap<>();

		for (Integer partition : partitions) {
			CompletableFuture<String> future = CompletableFuture
					.supplyAsync(() -> processPartition(partition), executor).exceptionally(ex -> {
						System.err
								.println("Partition " + partition + " failed: " + ex.getMessage());
						return "Failed";
					});

			futureMap.put(partition, future);
		}

		// Wait for all tasks to complete
		CompletableFuture<Void> allOf = CompletableFuture
				.allOf(futureMap.values().toArray(new CompletableFuture[0]));
		allOf.join();

		// Collect results
		futureMap.forEach((partition, future) -> {
			try {
				String result = future.get();
				System.out.printf("Partition %d Result: %s%n", partition, result);
			} catch (Exception e) {
				System.out.printf("Partition %d Result: Failed to retrieve%n", partition);
			}
		});

		executor.shutdown();
	}

	private static String processPartition(int partitionNumber) {
		// Simulate failure for partition 8
		if (partitionNumber == 8) {
			throw new RuntimeException("Simulated failure for partition " + partitionNumber);
		}
		// Simulate processing
		return "Processed Partition " + partitionNumber;
	}
}
