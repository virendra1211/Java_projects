package vk.learning.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
	public static void main(String[] args) {
		ReentrantLockExample obj = new ReentrantLockExample();
		obj.outerMethod();
	}

	private final Lock lock = new ReentrantLock();

	public void outerMethod() {
		lock.lock();
		try {
			System.out.println("outer method");
			innerMethod();
		} finally {
			lock.unlock();
		}
	}

	private void innerMethod() {
		lock.lock();
		try {
			System.out.println("inner method");
		} finally {
			lock.unlock();
			lock.unlock(); // IllegalMonitorException are getting because internally it's uses the count
							// and mantain the count
		}
	}
}
