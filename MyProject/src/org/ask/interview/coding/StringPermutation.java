package org.ask.interview.coding;

// Java program to print all the permutations
// of the given string ACI
public class StringPermutation {

	// Function to print all the permutations of str
	static void printPermutn(String str, String ans) {

		// If string is empty
		if (str.length() == 0) {
			System.out.println(ans + " ");
			return;
		}

		for (int i = 0; i < str.length(); i++) {

			// ith character of str
			char ch = str.charAt(i);
			// Rest of the string after excluding the ith character
			String lpart = str.substring(0, i);
			String rpart = str.substring(i + 1);
			String ros = lpart + rpart;
			// Recurvise call
			System.out.println(str);
			printPermutn(ros, ans + ch);
		}
	}

	// Driver code
	public static void main(String[] args) {
		String s = "GODE";

		printPermutn(s, "");
		StringBuilder s1 = new StringBuilder("Java");
		String s2 = "Love";
		s1.append(s2);
		s1.substring(4);
		int foundAt = s1.indexOf(s2);
		System.out.println(foundAt);
	}
}
