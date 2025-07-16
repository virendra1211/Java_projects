package vk.learning.string;

import java.util.LinkedHashSet;
import java.util.Set;

// sliding window 
public class UniqueCharForLongestString {

	public static void main(String[] args) {
		String str = "abcdbae"; // "abcdbaef"; //
		str = "abcdeacgbf";
		// three sum highest value
		// = "abcdbaef";
		// ans abcd
		int low = 0;
		System.out.println(longestUniqueSubstring(str));
	}

	public static String longestUniqueSubstring(String s) {
		Set<Character> seen = new LinkedHashSet<>();
		int left = 0, right = 0, maxLen = 0, maxStart = 0;

		while (right < s.length()) {
			char c = s.charAt(right);
			if (!seen.contains(c)) {
				seen.add(c);
				right++;
				if (right - left > maxLen) {
					maxLen = right - left;
					maxStart = left; // its required
				}
			} else {
				System.out.println(seen);
				seen.remove(s.charAt(left));
				left++;
			}
		}
		return s.substring(maxStart, maxStart + maxLen);
		// return s.substring(maxStart, maxStart + maxLen);
	}

}
