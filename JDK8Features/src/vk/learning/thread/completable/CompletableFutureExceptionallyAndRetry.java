
package vk.learning.thread.completable;

import java.io.File;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

/*
 * 6. Monitoring and Exception Handling
❓ "How do you monitor and handle failures in CompletableFuture?"

✅ Sample Answer:
I always use .exceptionally() or .handle() to manage exceptions.

For example:
 */
public class CompletableFutureExceptionallyAndRetry {
	public static void main(String[] args) {
		File file = new File("abc.txt"); // just to understand only

		CompletableFuture.supplyAsync(() -> {
			return retry(() -> readFile(file), 3); // Retry up to 3 times
		}).exceptionally(ex -> {
			// logger.error("❌ Failed to read file after retries: {}", file, ex);
			// alertService.notifyCritical("Read failure on file: " + file); // Optional
			// alerting
			return null;
		});

	}

	private static Object readFile(File file) {
		// TODO Auto-generated method stub
		return null;
	}

	public static <T> T retry(Supplier<T> task, int attempts) {
		int tries = 0;
		while (tries < attempts) {
			try {
				return task.get();
			} catch (Exception e) {
				tries++;
				if (tries >= attempts)
					throw e;
				try {
					Thread.sleep(500); // simple backoff
				} catch (InterruptedException ie) {
					Thread.currentThread().interrupt();
					throw new RuntimeException("Retry interrupted", ie);
				}
			}
		}
		return null;
	}

}
