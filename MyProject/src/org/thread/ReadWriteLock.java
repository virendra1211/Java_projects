package org.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLock<E> extends Thread {

	private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

	private Lock readLock = lock.readLock();
	private Lock writeLock = lock.writeLock();
	private List<E> list = new ArrayList<>();
	 private static  ReadWriteLock<Integer> sharedList;
	  
	public ReadWriteLock(ReadWriteLock<Integer> sharedList) {
        this.sharedList = sharedList;
    }
	public static void main(String[] args) {
		
	}
	 
    public void run() {
        Random random = new Random();
        int number = random.nextInt(100);
        sharedList.add(number);
 
        try {
            Thread.sleep(100);
            System.out.println(getName() + " -> put: " + number);
        } catch (InterruptedException ie ) { ie.printStackTrace(); }
    }

	private void add(E element) {
		writeLock.lock();
		try {
			list.add(element);
		} finally {
			writeLock.unlock();
		}
	}

	private E get(int index) {
		 readLock.lock();
		 
		 try {
			 return list.get(index);
		 }finally {
			 readLock.unlock();
		 }

	}

    public int size() {
        readLock.lock();
 
        try {
            return list.size();
        } finally {
            readLock.unlock();
        }
    }

}
