package org.thread;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

class Counter implements Runnable {
    private static int counter =0;
    private static final int limit = 1000;
    private static final int threadPoolSize = 5;
    //private static final Object lock = new Object();
    ReentrantLock lock;
    public Counter(ReentrantLock sharedLock) {
    	this.lock = sharedLock;
    }

	public static void main(String[] args) {
    //	 counter = new AtomicInteger(0);
        ExecutorService executorService = Executors.newFixedThreadPool(threadPoolSize);
        ReentrantLock sharedLock = new ReentrantLock();  // III way
        for (int i = 0; i < threadPoolSize; i++) {
            executorService.submit(new Counter(sharedLock));
        }
        executorService.shutdown();
    }

    @Override
    public void run() {
        while (counter < limit) {
		// while (counter.get() < limit) {
			increaseCounter();
		}
    }

    private void increaseCounter() {
			//System.out.println(Thread.currentThread().getName() + " : " + counter.incrementAndGet());
    	  lock.lock();
          try {
              System.out.println(Thread.currentThread().getName() + " : " + counter);
              counter++;
          } finally {
              lock.unlock();
          }	
    }
}