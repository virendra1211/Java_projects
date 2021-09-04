package org.thread;
/*
 May be the question like , suppose I want to give a way that other thread see the same value then what should I do.?? 
 below answer
	Now all threads will see the same initial value when calling get() before having called set() .
	can be use if multiple thread is belongs to different location or to create session in hiberante 
 */
public class ThreadLocalTest {
	public static void main(String[] args) throws InterruptedException {
	        MyRunnable sharedRunnableInstance = new MyRunnable();

	        Thread thread1 = new Thread(sharedRunnableInstance);
	        Thread thread2 = new Thread(sharedRunnableInstance);

	        thread1.start();
	        thread2.start();

	        thread1.join(); //wait for thread 1 to terminate
	        thread2.join(); //wait for thread 2 to terminate

	}

	public static class MyRunnable implements Runnable {
		private ThreadLocal threadLocal = new ThreadLocal<String>() {
		    @Override protected String initialValue() {
		        return "This is the initial value";
		    }
		};  

		@Override
		public void run() {
			System.out.println("Before setting value is "+threadLocal.get());
			threadLocal.set((int) (Math.random() * 100D));

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
			}

			System.out.println(threadLocal.get());
		}

	}

	}
