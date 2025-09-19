package vk.learning.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SyncTest {
	public static void main(String[] args) {
		BankAccount bankAccount = new BankAccount();
		Runnable task = () -> {
			bankAccount.withdraw(50);
		};
		Thread t1 = new Thread(task, "Thread 1");
		Thread t2 = new Thread(task, "Thread 2");
		t1.start();
		t2.start();

	}
}

class BankAccount {
	private int balance = 100;

	private final Lock lock = new ReentrantLock();

	public void withdraw(int amount) {
		System.out.println(Thread.currentThread().getName() + " attempting to withdraw " + amount);
		try {
			if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) { // if lock is not free then don't wait acquire
																// the lock if its free
				// within the given waiting time and the current thread has not been
				// interrupted.
				if (balance >= amount) {
					try {
						System.out.println(Thread.currentThread().getName() + " proceeding withwithdrawal");
						Thread.sleep(1000);
						balance -= amount;
						System.out
								.println(Thread.currentThread().getName() + " remaining balance: " + balance);
					} catch (Exception e) {
						Thread.currentThread().interrupt();
					} finally {
						lock.unlock();
					}
				} else {
					System.out.println(Thread.currentThread().getName() + " insufficient balance");
				}
			} else {
				System.out.println(Thread.currentThread().getName() + " Could not acquire the lock !!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
