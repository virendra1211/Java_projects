package vk.learning.important.interview;

import java.util.Arrays;

public class RoundUpToNextHundred {

	public static int roundUpToNextHundred(int number) {
		// If number is already a multiple of 100, return it
		if (number % 100 == 0) {
			return number;
		}
		// Otherwise, round up to next hundred
		return ((number / 100) + 1) * 100;
	}

	public static void main(String[] args) {

		anagramString();
		int[] inputs = { 386, 94, 18, 7462, 756283, 999, 1234 };

		for (int number : inputs) {
			int output = roundUpToNextHundred(number);
			System.out.println(number + " -> " + output);
		}
	}

	private static void anagramString() {
		String s1 = "anagram";
		String s2 = "nagaram";
		char[] s12 = s1.toCharArray();
		char[] s22 = s2.toCharArray();
		Arrays.sort(s12);
		Arrays.sort(s22);
		// Convert char[] to String properly
		String sortedS1 = new String(s12);
		String sortedS2 = new String(s22);

		System.out.println(sortedS1.equals(sortedS2)); // true
	}
}
