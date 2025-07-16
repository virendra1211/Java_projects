package org.jdk8;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapInternal {
	public static void main(String[] args) {
		// Executors.newVirtualThreadPerTaskExecutor()
		CompletableFuture<Integer> cf = CompletableFuture.supplyAsync(() -> 5 + 5);
		cf.thenApply(result -> result * 2).thenAccept(System.out::println); // Non-blocking chaining
		/*
		 * List<Integer> list = Arrays.asList(1, 4, 6); list.add(3); //
		 * UnSupportedOperationEXception
		 */

		Map<String, String> concurrentHashMap = new ConcurrentHashMap<String, String>();
		for (int i = 1; i <= 20; i++) {
			String key = "a" + i;
			String value = "$" + key;
			concurrentHashMap.put(key, value);
		}

	}
}
