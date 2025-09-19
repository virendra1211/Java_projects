package vk.learning.concept;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConceptStreamCheck {
	final Object lock = new Object();
	final int max = 10;
	int number = 1;

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		ConceptStreamCheck print = new ConceptStreamCheck();
		executor.submit(print::printOdd);
		executor.submit(print::printEven);

		executor.shutdown();
	}

	private void printOdd() {
		while (number <= max) {
			synchronized (lock) {
				while (number % 2 == 0) {
					try {
						lock.wait();
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				if (number <= max) {
					System.out.println("Odd: " + number);
					number++;
					lock.notify();
				}
			}
		}
	}

	private void printEven() {
		while (number <= max) {
			synchronized (lock) {
				while (number % 2 == 1) {
					try {
						lock.wait();
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
				if (number <= max) {
					System.out.println("Even: " + number);
					number++;
					lock.notify();
				}
			}
		}
	}

}
