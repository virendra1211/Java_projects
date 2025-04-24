package vk.learning.thread;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// Executor completable future async very good link to understand
// https://www.baeldung.com/java-executorservice-vs-completablefuture
public class FirstAvailableServiceExample {

    public static void main(String[] args) throws Exception {
	ExecutorService executorService = Executors.newFixedThreadPool(3);

	Set<Callable<String>> priceFetchers = new HashSet<>();

	priceFetchers.add(() -> {
	    // Simulate delay
	    TimeUnit.MILLISECONDS.sleep(300);
	    return fetchPriceFromServiceA();
	});

	priceFetchers.add(() -> {
	    TimeUnit.MILLISECONDS.sleep(100); // Fastest
	    return fetchPriceFromServiceB();
	});

	priceFetchers.add(() -> {
	    TimeUnit.MILLISECONDS.sleep(500);
	    return fetchPriceFromServiceC();
	});

	try {
	    // Return the first completed result
	    String bestPriceResponse = executorService.invokeAny(priceFetchers);
	    System.out.println("Received price: " + bestPriceResponse);

	    /*
	     * List<Future<String>> bestPriceResponse =
	     * executorService.invokeAll(priceFetchers); for (Future fb : bestPriceResponse)
	     * { System.out.println(fb.get()); }
	     */
	} finally {
	    executorService.shutdown();
	}
    }

    static String fetchPriceFromServiceA() {
	// Simulate remote call
	return "Service A - $10.99";
    }

    static String fetchPriceFromServiceB() {
	return "Service B - $9.49";
    }

    static String fetchPriceFromServiceC() {
	return "Service C - $11.29";
    }
}
