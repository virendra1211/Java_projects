package org.thread;

public class MovieBookApp extends Thread {
	public static void main(String[] args) {
		TotalEarning t = new TotalEarning();
		t.start();
		synchronized (t) {
				try {
					t.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		}

		System.out.println("total earning "+t.total+" rs");
		// Two thread is running one is main and other which we have created
		// some time will get "total earning 0 rs" out put
		
	}
	
}

class TotalEarning extends Thread{
	int total=0;
	public void run() {
		synchronized(this) {
			for(int i=0;i<=10;i++) {
				total = total+100;
			}
			this.notify();
		}
	}
}