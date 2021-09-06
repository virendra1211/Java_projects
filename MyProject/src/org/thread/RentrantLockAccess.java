package org.thread;

import java.util.concurrent.locks.ReentrantLock;

/*
 * Longest waiting thread will acquire the lock first
 */
public class RentrantLockAccess {
	
	private static ReentrantLock lock = new ReentrantLock();

	public static void main(String[] args) {
		Thread t1 = new Thread(() -> accessResource()); t1.start();
		Thread t2 = new Thread(() -> accessResource()); t2.start();
		Thread t3 = new Thread(() -> accessResource()); t3.start();
		Thread t4 = new Thread(() -> accessResource()); t4.start();
	}

	private static void accessResource() {
		// aquire them in any order 
		// big problem always advisable try finally use, to unlock the method, if any exception occur then it's not going to unlcok
		
		lock.lock();
		
		int number = lock.getHoldCount();
		System.out.println(number);
		lock.unlock();
	}
	
}
