package vk.learning.string;

public class PalidromStringComlexRecursion {
	public static void main(String[] args) {
		String input = "babad";
		System.out.println(longestPalidrome(input));
		System.out.println(isValidPalindrom(input));
	}

	private static String longestPalidrome(String input) {
		int max = 0;
		int start = 0;
		int end = 0;
		int numLength = input.length();
		for (int i = 0; i < numLength; i++) {
			for (int j = i; j < numLength; j++) {
				if (isPaldirome(input, i, j)) {
					if ((j - i + 1) > max) {
						max = j - i + 1;
						start = i;
						end = j;
					}
				}
			}
		}

		return input.substring(start, end + 1);

	}

	private static boolean isPaldirome(String input, int left, int right) {

		while (left < right) {
			if (input.charAt(left++) != input.charAt(right--)) {
				return false;
			}
		}

		return true;
	}

	private static boolean isValidPalindrom(String s) {
		int start = 0, end = s.length() - 1;
		while (start < end) {
			if (s.charAt(start) != s.charAt(end)) {
				// Try removing either left or right character
				return isPalindrom(s, start + 1, end) || isPalindrom(s, start, end - 1);
			}
			++start;
			--end;
		}
		return true;
	}

	private static boolean isPalindrom(String s, int start, int end) {
		while (end > start) {
			if (s.charAt(start) != s.charAt(end)) {
				return false;
			}
			++start;
			--end;
		}
		return true;
	}
}