package vk.learning.thread.interview.ecommerce;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ECommerseAmazonProductInventoryReview {
	private final ExecutorService executor = Executors.newFixedThreadPool(3);

	public static void main(String[] args) {
		/*
		 * CompletableFuture<Product> productFuture = ... CompletableFuture<Inventory>
		 * inventoryFuture = ... CompletableFuture<Reviews> reviewsFuture = ...
		 * 
		 * return productFuture .thenCombine(inventoryFuture, ProductWithStock::new)
		 * .thenCombine(reviewsFuture, ProductFullDetails::new) .join();
		 */
		ECommerseAmazonProductInventoryReview eCommerse = new ECommerseAmazonProductInventoryReview();
		System.out.println(eCommerse.getProductDetails(5));

	}

	public ProductDetails getProductDetails(int id) {
		ProductService productService = new ProductService();
		InventoryService inventoryService = new InventoryService();
		ReviewService reviewService = new ReviewService();
		CompletableFuture<Product1> productFuture = CompletableFuture
				.supplyAsync(() -> productService.getProduct(id), executor);

		CompletableFuture<Inventory1> inventoryFuture = CompletableFuture
				.supplyAsync(() -> inventoryService.getInventory(id), executor);

		CompletableFuture<Review1> reviewFuture = CompletableFuture
				.supplyAsync(() -> reviewService.getReview(id), executor);

		CompletableFuture.allOf(productFuture, inventoryFuture, reviewFuture).join(); // more
																						// simpler

		Product1 product = productFuture.join();
		Inventory1 inventory = inventoryFuture.join();
		Review1 review = reviewFuture.join();

		return new ProductDetails(product, inventory, review);
	}
}

class ProductService {
	public Product1 getProduct(int id) {
		sleep(500); // simulate delay
		return new Product1(id, "iPhone 15", "Latest Apple iPhone", 1299.99);
	}

	private void sleep(long ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException ignored) {
		}
	}
}

class InventoryService {
	public Inventory1 getInventory(int productId) {
		sleep(700); // simulate delay
		return new Inventory1(true);
	}

	private void sleep(long ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException ignored) {
		}
	}
}

class ReviewService {
	public Review1 getReview(int productId) {
		sleep(1000); // simulate delay
		return new Review1(4.6, List.of("Awesome!", "Could be cheaper."));
	}

	private void sleep(long ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException ignored) {
		}
	}
}