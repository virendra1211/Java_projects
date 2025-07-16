package vk.learning.string;

import java.util.HashSet;
import java.util.Set;

public class DictionaryFilter {

	public static String solution(String dictionary, String message) {
		// Convert dictionary to a set of lowercase words
		Set<String> dictSet = new HashSet<>();
		for (String word : dictionary.toLowerCase().split("\\s+")) {
			dictSet.add(word);
		}

		// Process each word in the message
		StringBuilder result = new StringBuilder();
		for (String word : message.split("\\s+")) {
			if (dictSet.contains(word.toLowerCase())) {
				result.append(word);
			} else {
				result.append("###");
			}
			result.append(" ");
		}

		// Remove trailing space and return
		return result.toString().trim();
	}

	public static void main(String[] args) {
		String dictionary = "The codility coders test";
		String message = "Codility tests the codes of coders";

		String output = solution(dictionary, message);
		System.out.println(output); // Output: Codility ### the ### ### coders
	}
}
