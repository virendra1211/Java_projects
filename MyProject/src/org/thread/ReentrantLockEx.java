package org.thread;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockEx {
    static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {

	Thread t1 = new Thread(() -> accessResource());
	t1.start();

	Thread t2 = new Thread(() -> accessResource());
	t2.start();

	Thread t3 = new Thread(() -> accessResource());
	t3.start();

    }

    private static void accessResource() {
	lock.lock();
	lock.tryLock();
	// do something here
	System.out.println("test ");
	lock.unlock();

    }
}
