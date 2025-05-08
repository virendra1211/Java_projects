package vk.learning.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/*
 * ExecutorService doesn’t offer built-in timeout functionality. To implement timeouts,
 *  we need to work with Future objects and potentially 
 * interrupt tasks exceeding the deadline. This approach involves manual coordination:


 */
public class ExecutorTimeout {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		Future<String> future = executor.submit(() -> {
			try {
				Thread.sleep(1000);
			} catch (Exception exeption) {
				System.out.println("exception ");
			}
			return "Task Complete";
		});

		try {
			String result = future.get(5, TimeUnit.MILLISECONDS);
			System.out.println("result " + result);
		} catch (TimeoutException e) {
			System.out.println("Task Execution timeout !");
			future.cancel(true); // manuall interrupt the task
		} catch (Exception e) {
		} finally {
			executor.shutdown();
		}

	}

}
/*
 * It’s important to note that while the timeout mechanism interrupts the
 * waiting for the task result, the task itself will continue running in the
 * background until it either completes or is interrupted. For instance, to
 * interrupt a task running within an ExecutorService, we need to use the
 * Future.cancel(true) method.
 */
