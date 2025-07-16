package vk.learning.thread.completable;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;

import net.jodah.failsafe.Failsafe;
import net.jodah.failsafe.RetryPolicy;

public class CompletableFailSafeWithRetry {

}

class FileReaderService {

	private static final RetryPolicy<String> retryPolicy = new RetryPolicy<String>()
			.handle(IOException.class)
			.withBackoff(Duration.ofMillis(500), Duration.ofSeconds(2), 2.0).withMaxRetries(3)
			.onRetry(event -> System.out.println("Retrying due to: " + event.getLastFailure()))
			.onFailure(event -> System.err
					.println("Final failure after retries: " + event.getException()));

	public static void main(String[] args) {
		String file = "important-data.txt";

		CompletableFuture.supplyAsync(() -> Failsafe.with(retryPolicy).get(() -> readFile(file)))
				.thenAccept(content -> {
					if (content != null) {
						System.out.println("✅ File read successfully: " + file);
					} else {
						System.err.println("⚠️ File content is null: " + file);
					}
				}).exceptionally(ex -> {
					System.err.println("❌ Unrecoverable error while processing " + file);
					ex.printStackTrace();
					// Optionally trigger alerts here
					return null;
				});
	}

	private static String readFile(String file) throws IOException {
		// Simulate random failure
		if (Math.random() < 0.5) {
			throw new IOException("Simulated read error for: " + file);
		}
		return "File content of " + file;
	}
}
