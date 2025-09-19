package vk.learning.algo;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DSAOfTraingle {
	public static void main(String[] args) {
		int num = 6;
		printBy(num);
	}

	private static void printBy(int num) {
		List<Stack<Integer>> list = new ArrayList<>();
		int sequence = 1;
		int loop = 0;

		for (int i = 0; i < num; i++) {
			int size = list.size();
			if (size <= i) {
				list.add(new Stack<Integer>());
			}
			list.get(i).push(sequence++);
			if (i == num - 1) {
				i = loop;
				loop++;
			}
		}

		for (Stack<Integer> stack : list) {
			while (!stack.isEmpty()) {
				System.out.print(stack.pop() + " ");
			}
			System.out.println();
		}

	}
}
