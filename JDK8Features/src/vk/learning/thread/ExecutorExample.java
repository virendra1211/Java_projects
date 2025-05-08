package vk.learning.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ExecutorExample {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newFixedThreadPool(1);

		executorService.submit(() -> System.out.println("Virendra1"));
		executorService.submit(() -> System.out.println("Virendra2"));
		executorService.submit(() -> System.out.println("Virendra3"));
		Future future = executorService.submit(() -> {
			return "abc";
		});

		executorService.awaitTermination(1, TimeUnit.SECONDS);
		executorService.submit(() -> System.out.println("Virendra5"));
		System.out.println(future.get());
		executorService.shutdown();
	}
}
