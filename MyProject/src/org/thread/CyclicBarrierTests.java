package org.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ThreadLocalRandom;

public class CyclicBarrierTests {
    private final static int NO_OF_PARTIES = 5;

    public static void main(String[] args) {

	CyclicBarrier meetingPoint = new CyclicBarrier(NO_OF_PARTIES);
	for (int i = 1; i <= NO_OF_PARTIES; i++) {
	    Friend friend = new Friend(meetingPoint, "Friend" + i);
	    friend.start();
	}

    }
}

class Friend extends Thread {
    private final CyclicBarrier barrier;
    private final String friendName;

    public Friend(CyclicBarrier barrier, String friendName) {
	this.barrier = barrier;
	this.friendName = friendName;
    }

    @Override
    public void run() {
	System.out.println(friendName + " is getting ready !!!");
	getReadyAndBeAtMeetingPoint();
	System.out.println(friendName + " is ready and waiting for "
		+ (barrier.getParties() - barrier.getNumberWaiting() - 1) + " Friends at the Meeting Point");
	try {
	    barrier.await();
	} catch (InterruptedException | BrokenBarrierException e) {
	    e.printStackTrace();
	}
	System.out.println(friendName + " is now continuing with the Trip");
    }

    private void getReadyAndBeAtMeetingPoint() {
	try {
	    Thread.sleep(ThreadLocalRandom.current().nextLong(5000, 15000));
	} catch (InterruptedException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }
}
