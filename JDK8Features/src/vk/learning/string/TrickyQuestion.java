package vk.learning.string;

import java.util.Stack;

public class TrickyQuestion {
	public static void main(String[] args) {
		String input = "3[a]2[bc]";
		// String input = "3[a2[c]]";
		String result = trickyMethod(input);
		System.out.println(result); // Expected output: aaabcbc
	}

	private static String trickyMethod(String s) {
		Stack<Integer> countStack = new Stack<>();
		Stack<StringBuilder> stringStack = new Stack<>();
		StringBuilder current = new StringBuilder();
		int k = 0;

		for (char ch : s.toCharArray()) {
			if (Character.isDigit(ch)) {
				k = k * 10 + (ch - '0'); // handle multi-digit numbers
			} else if (ch == '[') {
				countStack.push(k);
				stringStack.push(current);
				current = new StringBuilder();
				k = 0;
			} else if (ch == ']') {
				StringBuilder decoded = stringStack.pop();
				int repeatTimes = countStack.pop();
				for (int i = 0; i < repeatTimes; i++) {
					decoded.append(current);
				}
				current = decoded;
			} else {
				current.append(ch);
			}
		}

		return current.toString();
	}
}
