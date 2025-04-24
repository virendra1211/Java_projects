package org.thread;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureExceptionHandleExecutor {
    public static void main(String[] args) {
	CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
	    if (true) {
		throw new RuntimeException("Something went wrong!");
	    }
	    return "Success";
	}).exceptionally(ex -> {
	    System.err.println("Error in task: " + ex.getMessage());
	    return "Error occurred"; // Can optionally return a default value
	});

	future.thenAccept(result -> System.out.println("Result: " + result));

    }

}
