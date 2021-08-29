package org.thread;
import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample{
	public static void main(String[] args) {

		Thread t1 = new Thread(() -> System.out.print("a"));
		Thread t2 = new Thread(() -> System.out.print("a"));
		Thread t3 = new Thread(() -> System.out.print("a"));

//		CompletableFuture<String> future = 
		  CompletableFuture.supplyAsync(() -> t1).thenApply()
	}
}


