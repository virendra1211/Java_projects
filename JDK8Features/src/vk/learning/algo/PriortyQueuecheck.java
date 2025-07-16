package vk.learning.algo;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriortyQueuecheck {

	public static void main(String[] args) {
		Queue<Integer> expense = new PriorityQueue<>();

		expense.add(1);
		expense.add(3);
		expense.add(2);
		expense.add(-4);
		expense.add(-8);
		System.out.println(expense);
		System.out.println(expense.poll());
		System.out.println(expense);
		expense.offer(10);
		expense.offer(11);
		System.out.println(expense);
		expense.offer(9);
		System.out.println(expense);
		expense.poll();
		System.out.println(expense);

	}

}
