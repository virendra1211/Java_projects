package vk.learning.string;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveDuplicates {

	public static String removeDuplicates(String s, int k) {
		// Stack holds pairs of (character, count)
		Deque<Pair> stack = new ArrayDeque<>();

		for (char c : s.toCharArray()) {
			if (!stack.isEmpty() && stack.peek().ch == c) {
				stack.peek().count++;
				if (stack.peek().count == k) {
					stack.pop(); // Remove the group of k characters
				}
			} else {
				stack.push(new Pair(c, 1));
			}
		}

		// Rebuild the result from the stack
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			Pair p = stack.removeLast(); // maintain original order
			for (int i = 0; i < p.count; i++) {
				sb.append(p.ch);
			}
		}

		return sb.toString();
	}

	// Helper class to store character and its count
	static class Pair {
		char ch;
		int count;

		Pair(char ch, int count) {
			this.ch = ch;
			this.count = count;
		}
	}

	public static void main(String[] args) {
		// System.out.println(removeDuplicates("abcd", 2)); // abcd
		System.out.println(removeDuplicates("deeedbbcccbdaa", 3)); // aa
		System.out.println(removeDuplicates("pbbcggttciiippooaais", 2)); // ps
	}
}
