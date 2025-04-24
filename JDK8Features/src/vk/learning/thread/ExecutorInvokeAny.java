package vk.learning.thread;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorInvokeAny {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
	ExecutorService executorService = Executors.newFixedThreadPool(3);

	Set<Callable<String>> callables = new HashSet<>();

	callables.add(() -> "Task 1");
	callables.add(() -> "Task 2");
	callables.add(() -> "Task 3");

	String result = executorService.invokeAny(callables);
	System.out.println(result);
	executorService.shutdown();

    }

}
