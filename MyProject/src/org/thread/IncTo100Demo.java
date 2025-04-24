package org.thread;

/*
 Run mutliple thread and count should be increase/share that's why out put should be 1, 2 ,3 ...
 It's interview question asked by one of the company may be N
 */
class IncTo100Demo implements Runnable {
    public volatile int count = 1;

    public void run() {
	Thread current = Thread.currentThread();
	try {
	    while (count < 21) {
		System.out.println(current.getName() + " count = " + count++);
		current.sleep(1000);
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    public static void main(String[] args) {
	IncTo100Demo instance = new IncTo100Demo();
	Thread one = new Thread(instance, "one");
	Thread two = new Thread(instance, "two");

	try {
	    one.start();
	    two.start();
	    System.out.println("one alive? " + one.isAlive());
	    one.join();
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
}
