package vk.learning.important.interview;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class BigCSVFileRead {

	private static final int BATCH_SIZE = 500; // Tune based on your DB performance
	private static final int THREAD_POOL_SIZE = Runtime.getRuntime().availableProcessors() * 2;

	private static final ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

	private static final ProductRepository repository = new ProductRepository(); // Assume it's injected

	public static void main(String[] args) throws Exception {
		Path csvPath = Path.of("products.csv");

		try (BufferedReader br = new BufferedReader(new FileReader(csvPath.toFile()))) {
			List<Long> batch = new ArrayList<>(BATCH_SIZE);
			String line;

			while ((line = br.readLine()) != null) {
				Long productId = Long.parseLong(line.trim());
				batch.add(productId);

				if (batch.size() == BATCH_SIZE) {
					submitBatch(new ArrayList<>(batch));
					batch.clear();
				}
			}

			// process last remaining batch
			if (!batch.isEmpty()) {
				submitBatch(batch);
			}
		}

		executor.shutdown();
		executor.awaitTermination(1, TimeUnit.HOURS);
	}

	private static void submitBatch(List<Long> productIds) {
		CompletableFuture.runAsync(() -> processBatches(productIds), executor).exceptionally(ex -> {
			System.err.println("Error processing batch: " + ex);
			return null;
		});
	}

	private static void processBatches(List<Long> batch) {
		// Fetch all in a single query instead of N+1 calls
		List<Product11> products = repository.findAllById(batch);

		products.forEach(product -> {
			// Update, transform, or publish
			// publishEvent(product);
		});
	}
}

// Example repository placeholder
class ProductRepository {
	public List<Product11> findAllById(List<Long> ids) {
		// Ideally use a single DB query here
		return ids.stream().map(Product11::new).collect(Collectors.toList());
	}
}

// Example Product class
class Product11 {
	private Long id;

	public Product11(Long id) {
		this.id = id;
	}
}
