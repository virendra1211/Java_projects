package vk.learning.thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/* java 9 Completable Future offers a more treamlined approach to timeout with methods like
 * completeOnTimeout(). 
 * https://www.baeldung.com/java-executorservice-vs-completablefuture#2-completablefuture-3
 */
public class CompletableFutureTimeOut {

	public static void main(String[] args) {

		CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException te) {
			}
			return "Task Completed";
		});

		CompletableFuture<String> timeOut = completableFuture.completeOnTimeout("TimeOut", 1001,
				TimeUnit.MILLISECONDS);
		String result = timeOut.join();
		System.out.println("Result " + result);

	}

}
