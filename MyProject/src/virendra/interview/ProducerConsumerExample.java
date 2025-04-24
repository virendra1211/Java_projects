package virendra.interview;
// Java program to implement solution of producer

// consumer problem.

import java.util.LinkedList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerExample {
    public static void main(String[] args) throws InterruptedException {
	// Object of a class that has both produce()
	// and consume() methods

	int capacity = 2;
	BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(capacity);
	final PC pc = new PC(blockingQueue);
	// Create producer thread
	Thread t1 = new Thread(() -> {
	    try {
		pc.produce();
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }
	});

	/*
	 * Thread t11 = new Thread(() ->{ try { pc.produce(); }catch
	 * (InterruptedException e) { e.printStackTrace(); } } );
	 */
	// Create consumer thread
	Thread t2 = new Thread(() -> {
	    try {
		pc.consume();
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }
	});

	// Start both threads
	t1.start();
	t2.start();

	// t1 finishes before t2
	// t1.join();
	// t2.join();
    }

    // This class has a list, producer (adds items to list
    // and consumer (removes items).
    public static class PC {

	// Create a list shared by producer and consumer
	// Size of list is 2.
	LinkedList<Integer> list = new LinkedList<>();
	int capacity = 2;
	BlockingQueue<Integer> blockingQueue;

	public PC(BlockingQueue<Integer> blockingQueue) {
	    this.blockingQueue = blockingQueue;
	}

	// Function called by producer thread
	public void produce() throws InterruptedException {
	    int value = 0;
	    while (true) {
		/*
		 * synchronized (this) { // producer thread waits while list // is full while
		 * (list.size() == capacity) wait();
		 */
		System.out.println("Producer produced-" + value);
		blockingQueue.put(value++);

		/*
		 * * /* // to insert the jobs in the list list.add(value++);
		 * 
		 * // notifies the consumer thread that // now it can start consuming notify();
		 * 
		 * // makes the working of program easier // to understand
		 */ Thread.sleep(1000);
	    }
	}

	// Function called by consumer thread
	public void consume() throws InterruptedException {
	    while (true) {
		/*
		 * synchronized (this) { // consumer thread waits while list // is empty while
		 * (list.size() == 0) wait();
		 */
		int val = blockingQueue.take();

		// to retrieve the ifrst job in the list
		// int val = list.removeFirst();

		System.out.println("Consumer consumed-" + val);

		// Wake up producer thread
		// notify();

		// and sleep
		Thread.sleep(1000);
	    }
	}
    }
}
