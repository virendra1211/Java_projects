package org.thread;

import java.util.concurrent.ExecutorService;

/**
 * 
 * @author Virendra khade 
 * 			we use semaphore in the thread synchronization. It is used to
 *         control access to a shared resource that uses a counter variable Java
 *         also provides a Semaphore class that contains constructors and
 *         various methods to control access over the shared resource. --> 
 *         If counter > 0, access to shared resources is provided. --> 
 *         If counter = 0, access to shared resources is denied. Characteristics of Semaphore
 *         There are the following characteristics of a semaphore:
 * 
 *         It provides synchronization among the threads. It decreases the level
 *         of synchronization. Hence, provides a low-level synchronization
 *         mechanism. The semaphore does not contain a negative value. It holds
 *         a value that may either greater than zero or equal to zero. We can
 *         implement semaphore using the test operation and interrupts, and we
 *         use the file descriptors for executing it.
 * 
 */
public class SemaphoreTest {
	public static void main(String[] args) {

		ExecutorService ex = ExecutorServices.
	
	}
}

class CountingSemaphoreExample {
	private int signal = 0;

	public synchronized void take() {
		this.signal++;
		this.notify();
	}

	public synchronized void release() throws InterruptedException {
		while (this.signal == 0)
			wait();
		this.signal--;
	}
}
