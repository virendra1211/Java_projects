package vk.learning.string;

import java.util.ArrayList;
import java.util.List;

public class ParenthesisPrint {
	public static void main(String[] args) {
		int k = 2;
		System.out.println(generateParenthesis(k));
	}

	private static List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<>();
		generate("", 0, 0, n, result);
		return result;
	}

	private static void generate(String current, int open, int close, int max,
			List<String> result) {

		if (current.length() == max * 2) {
			result.add(current);
			return;
		}
		if (open < max)
			generate(current + "(", open + 1, close, max, result);

		if (close < open)
			generate(current + ")", open, close + 1, max, result);

	}
}
