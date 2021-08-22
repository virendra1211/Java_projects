package org.ask.interview.coding;
public class LongestPalindrome {

	public static void main(String[] args) {
		/*Steps
		 * 1. iterate string from first char and compare it with all substrings with bubble sort fashion
		 * 2. check given portion of string as palindrome or not and update maxlength 
		 * 3. return substring with from start index to maxlength
		 * */
		String longestPalindrome  = longestPalindrome("sachinranenar123");
		System.out.println(longestPalindrome);
	}

	private static String longestPalindrome(String str) {
		int maxLength = 1;
		int start=0;
		for (int i = 0; i < str.length(); i++) {
			for (int j = i; j < str.length(); j++) {
				
				if (checkPalindrome(str, i, j) && maxLength < (j-i+1)) {
					maxLength = j-i+1;
					start = i;
				}
			}
		}
		
		
		return str.substring(start, start+maxLength);
	}

	private static boolean checkPalindrome(String str, int start, int end) {
		
		for (int i = 0; i < (end-start+1)/2; i++) {
			if (str.charAt(start+i) != str.charAt(end-i)) {
				return false;
			}
			
		}
		return true;
	}
}
	