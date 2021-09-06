package org.thread;

public class TimerMain extends Thread {
	public static void main(String[] args) {
		Time t = new Time();
		t.start();
		synchronized (t) {
				try {
					t.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		}

		// Two thread is running one is main and other which we have created
		// some time will get "total earning 0 rs" out put
		
	}
	
}

class Time extends Thread{
	int time=0;
	public void run() {
		synchronized(this) {
			for(int i=0;i<=10;i++) {
				time = time+1;
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				notify();
			}
		}
	}
}