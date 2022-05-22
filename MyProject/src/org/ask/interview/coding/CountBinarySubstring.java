package org.ask.interview.coding;

public class CountBinarySubstring {
	public static void main(String[] args) {
		System.out.println(countBinarySubstrings("0110001111"));
	}

	public static int countBinarySubstrings(String s) {
		int curr = 1, prev = 0, ans = 0;
		for (int i = 1; i < s.length(); i++)
			if (s.charAt(i) == s.charAt(i - 1))
				curr++;
			else {
				ans += Math.min(curr, prev);
				prev = curr;
				curr = 1;
			}
		return ans + Math.min(curr, prev);
	}

}
