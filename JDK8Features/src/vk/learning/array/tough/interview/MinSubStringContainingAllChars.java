package vk.learning.array.tough.interview;

import java.util.LinkedHashSet;
import java.util.Set;

public class MinSubStringContainingAllChars {

	public static void main(String[] args) {
		String s = "ADOBECODEBANC";
		String t = "ABC";

		String minStringOrdered = minSubStringOrdered(s, t);

		System.out.println("minStringOrdered:" + minStringOrdered);

		// Unordered
		String minStringNonOrdered = minSubStringNonOrdered(s, t);

		System.out.println("minStringNonOrdered:" + minStringNonOrdered);

	}

	public static String minSubStringOrdered(String s, String t) {
		String minString = "";
		for (int i = 0; i < s.length(); i++) {
			StringBuilder sb = new StringBuilder(t);
			int start = i;
			while (start < s.length()) {
				if (s.charAt(start) == sb.charAt(0)) {
					sb.deleteCharAt(0);
				}
				if (sb.length() == 0) {
					if (minString.equals("")) {
						minString = s.substring(i, start + 1);
					} else if (minString.length() > s.substring(i, start + 1).length()) {
						minString = s.substring(i, start + 1);
					}
					break;
				}
				start++;
			}

		}
		return minString;
	}

	public static String minSubStringNonOrdered(String s, String t) {
		String minString = "";
		for (int i = 0; i < s.length(); i++) {
			Set<Character> chars = new LinkedHashSet<>();
			for (int j = 0; j < t.length(); j++) {
				chars.add(t.charAt(j));
			}

			int start = i;
			while (start < s.length()) {
				if (chars.contains(s.charAt(start))) {
					chars.remove(s.charAt(start));
				}
				if (chars.size() == 0) {
					if (minString.equals("")) {
						minString = s.substring(i, start + 1);
					} else if (minString.length() > s.substring(i, start + 1).length()) {
						minString = s.substring(i, start + 1);
					}
					break;
				}
				start++;
			}

		}
		return minString;
	}

}