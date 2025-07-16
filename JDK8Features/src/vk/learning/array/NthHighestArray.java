package vk.learning.array;

import java.util.PriorityQueue;

public class NthHighestArray {
	public static void main(String[] args) {
		int[] arr = { 22, 29, 23, 61, 50, 30, 32, 70, 60 };

		findOutNthHighest(arr, 3);
	}

	private static void findOutNthHighest(int[] arr, int k) {
		PriorityQueue<Integer> queue = new PriorityQueue<>();

		for (int num : arr) {
			queue.add(num);
			if (queue.size() > k) {
				queue.poll();
			}
		}
		System.out.println(queue.peek());
	}

}
