package org.ask.interview.coding;

public class LongestPalindrome {

	public static void main(String[] args) {
		/*
		 * Steps 1. iterate string from first char and compare it with all substrings
		 * with bubble sort fashion 2. check given portion of string as palindrome or
		 * not and update maxlength 3. return substring with from start index to
		 * maxlength
		 */
		LongestPalindrome pd = new LongestPalindrome();

		String pal = pd.findLongestPalindrome("bananas");
		System.out.println("" + pal);

		pal = pd.findLongestPalindrome("abaradar121");
		System.out.println("" + pal);
	}

	public String findLongestPalindrome(String s) {
		// Validations
		if (s.isEmpty()) {
			return "Please enter a String";
		}

		if (s.length() == 1) {
			return s;
		}
		// Validations end
		// Start with one char (starting) as a longest palindrome
		String longest = s.substring(0, 1);
		for (int i = 0; i < s.length(); i = i + 1) {
			// get longest palindrome for odd length (center is i)
			String tmp = checkForEquality(s, i, i);
			if (tmp.length() > longest.length()) {
				longest = tmp;
			}

			// get longest palindrome for even length (center is i, i+1)
			/*
			 * tmp = checkForEquality(s, i, i + 1); if (tmp.length() > longest.length()) {
			 * longest = tmp; }
			 */

		}
		return longest;
	}

	/**
	 * In this method equality is checked starting from the center moving one
	 * character left and one character right from the center. If both chars are
	 * equal then the next set of chars are checked.
	 * 
	 */
	public String checkForEquality(String s, int begin, int end) {
		while (begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)) {
			begin--;
			end++;
		}
		return s.substring(begin + 1, end);
	}

}
