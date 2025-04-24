package vk.learning.thread;

public class MyBasicThread {
    public static void main(String[] args) {
	// printTable(2);
	// printTable(3);
	Runnable r1 = new Runnable() {
	    @Override
	    public void run() {
		printTable(2);
	    }
	};

	Runnable r2 = new Runnable() {
	    @Override
	    public void run() {
		printTable(3);
	    }
	};
	Thread t1 = new Thread(r1);
	t1.start();

	Thread t2 = new Thread(r2);
	t2.start();

    }

    private static void printTable(int n) {
	for (int i = 1; i <= 10; i++) {
	    System.out.println(n + "X" + i + " = " + (n * i));
	    try {
		Thread.sleep(100);
	    } catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	}

    }
}
