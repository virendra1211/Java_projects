package vk.learning.string;

public class ReverseStringWithProperNaming {
	public static void main(String[] args) {
		// String input = " blue is the sky";
		// String input = " 123 456 79 111";
		String input = "abc";
		String reversedSentence = reverseWords(input);
		System.out.println(reversedSentence);
	}

	private static String reverseWords(String sentence) {

		if (sentence == null || sentence.trim().isEmpty()) { // null and empty should ve avoided to
			return "";
		}

		String[] words = sentence.trim().split(" ");
		if (words.length <= 1) { // 1. case even if single character and single string, we should
									// take care.
			return words[0];
		}

		StringBuilder reversed = new StringBuilder(); // this should be created if few corner test
														// has passed
		for (int i = words.length - 1; i >= 0; i--) {
			if (words[i].trim() == "") {
				continue;
			}
			reversed.append(words[i]);
			if (i > 0)
				reversed.append(" ");
		}

		return reversed.toString();
	}

}
