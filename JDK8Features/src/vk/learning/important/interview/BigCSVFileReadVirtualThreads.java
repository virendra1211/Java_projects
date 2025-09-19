package vk.learning.important.interview;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class BigCSVFileReadVirtualThreads {

	private static final int BATCH_SIZE = 1000;
	private static final ProductRepository12 repository = new ProductRepository12();

	public static void main(String[] args) throws Exception {
		Path csvPath = Path.of("products.csv");

		try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
			List<CompletableFuture<Void>> futures = new ArrayList<>();

			try (BufferedReader br = Files.newBufferedReader(csvPath)) {
				List<Long> batch = new ArrayList<>(BATCH_SIZE);
				String line;

				while ((line = br.readLine()) != null) {
					batch.add(Long.parseLong(line.trim()));
					if (batch.size() == BATCH_SIZE) {
						List<Long> batchCopy = List.copyOf(batch);
						futures.add(CompletableFuture.runAsync(() -> processBatch(batchCopy), executor));
						batch.clear();
					}
				}
				if (!batch.isEmpty()) {
					List<Long> batchCopy = List.copyOf(batch);
					futures.add(CompletableFuture.runAsync(() -> processBatch(batchCopy), executor));
				}
			}

			CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
		}
	}

	private static void processBatch(List<Long> batch) {
		List<Product> products = repository.findAllById(batch);
		products.forEach(product -> {
			// process product
		});
	}
}

class ProductRepository12 {
	public List<Product> findAllById(List<Long> ids) {
		// Simulate DB query latency
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
		}
		return ids.stream().map(Product::new).collect(Collectors.toList());
	}
}

class Product {
	private final Long id;

	public Product(Long id) {
		this.id = id;
	}
}
