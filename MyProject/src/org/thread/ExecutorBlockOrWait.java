package org.thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorBlockOrWait {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
	ExecutorService executor = Executors.newFixedThreadPool(2);

	Future<Integer> firstTask = executor.submit(() -> {
	    return 42;
	});

	Future<String> secondTask = executor.submit(() -> {
	    try {
		Integer first = firstTask.get();
		return "Returned result based on first " + first;
	    } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	    return null;
	});
	System.out.println(secondTask.get());
	executor.shutdown();

	// Below is the Completable future in the sameway but here we are not blocking,
	// by using then
	/* 	*/
	CompletableFuture<Integer> cf = CompletableFuture.supplyAsync(() -> {
	    return 32;
	});
	CompletableFuture<String> second = cf.thenApply(result -> {
	    return "its completed " + result;
	});
	System.out.println(second.get());

	// /***********exception in executor ****************/
	ExecutorService executor1 = Executors.newFixedThreadPool(2);

	Future<String> future = executor1.submit(() -> {
	    if (true) {
		System.out.println("inside throw");
		throw new RuntimeException("Something went wrong!");
	    }
	    return "Success";
	});

	try {
	    String result = future.get();
	    System.out.println("Result: " + result);
	} catch (Exception e) {
	    System.out.println(e.getMessage());
	} finally {
	    executor.shutdown();
	}
    }
}
