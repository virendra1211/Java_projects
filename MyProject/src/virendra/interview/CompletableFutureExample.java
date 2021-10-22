package virendra.interview;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CompletableFutureExample {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Instant start = Instant.now();

		for (int i = 0; i < 10; i++) {
			ExecutorService executor = Executors.newFixedThreadPool(4); // added 4 threads

			OrderFetcher orderFetcher = new OrderFetcher();
			Future<Integer> future1 = executor.submit(orderFetcher);

			InventoryChecker inventoryChecker = new InventoryChecker(future1.get());
			System.out.println("Order Number is: " + future1.get());
			Future<Boolean> future2 = executor.submit(inventoryChecker);

			PaymentAcceptor PaymentAcceptor = new PaymentAcceptor(future2.get());
			System.out.println("Is Inventory Present " + future2.get());
			Future<String> future3 = executor.submit(PaymentAcceptor);
			System.out.println(future3.get());

			executor.shutdown();
		}
		Instant end = Instant.now();
		long timeElapsed = Duration.between(start, end).toMillis();
		System.out.println("Time elapsed " + timeElapsed);
	}
}
