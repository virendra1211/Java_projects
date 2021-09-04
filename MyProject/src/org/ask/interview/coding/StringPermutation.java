package org.ask.interview.coding;
// Java program to print all the permutations
// of the given string
public class StringPermutation {

	// Function to print all the permutations of str
	static void printPermutn(String str, String ans)
	{
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
			//System.out.println(str+"++"+i+"  "+ch+"--"+ros +"---"+ans+ch+" -- ");
			printPermutn(ros, ans + ch);
		}
	}

	// Driver code
	public static void main(String[] args)
	{
		String s = "abcd";
		printPermutn(s, "");
	}
}
