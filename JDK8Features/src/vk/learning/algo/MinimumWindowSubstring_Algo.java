package vk.learning.algo;

/*
 * 
Code
Testcase
Test Result
Test Result
76. Minimum Window Substring
Hard
Topics
premium lock icon
Companies
Hint
Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.

 

Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
https://leetcode.com/problems/minimum-window-substring/description/
 */
import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring_Algo {
	public static void main(String[] args) {
		String s = "ADOBECODEBANC";
		String t = "ABC";
		System.out.println(minWindow(s, t)); // Output: "BANC"
	}

	public static String minWindow(String s, String t) {
		if (s.length() < t.length())
			return "";

		// Frequency map for t
		Map<Character, Integer> need = new HashMap<>();
		for (char c : t.toCharArray()) {
			need.put(c, need.getOrDefault(c, 0) + 1);
		}

		Map<Character, Integer> window = new HashMap<>();
		int left = 0, right = 0, valid = 0;
		int minLen = Integer.MAX_VALUE;
		int start = 0;

		while (right < s.length()) {
			char c = s.charAt(right);
			right++;

			if (need.containsKey(c)) {
				window.put(c, window.getOrDefault(c, 0) + 1);
				if (window.get(c).intValue() == need.get(c).intValue()) {
					valid++;
				}
			}

			// Shrink the window when all required chars are inside
			while (valid == need.size()) {
				if (right - left < minLen) {
					minLen = right - left;
					start = left;
				}

				char d = s.charAt(left);
				left++;

				if (need.containsKey(d)) {
					if (window.get(d).intValue() == need.get(d).intValue()) {
						valid--;
					}
					window.put(d, window.get(d) - 1);
				}
			}
		}

		return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
	}
}
