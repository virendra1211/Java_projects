package vk.learning.practice;

import java.util.function.Function;
import java.util.stream.Collectors;

public class StringPractice {

	public static void main(String[] args) {
		String str = "I am an Indian";

		str.chars().mapToObj(c -> (char) c).filter(ch -> ch != ' ')
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.entrySet().stream()
				.forEach(e -> System.out.println(e.getKey() + " - " + e.getValue()));
		System.out.println("*************");
		sequenceOfAnotherString();

	}

	private static void sequenceOfAnotherString() {

		String s1 = "net";
		String s2 = "npeght";

		/*
		 * String s1 = "abc"; String s2 = "asc";
		 */
		int firstStringIndex = 0;
		int secondStringIndex = 0;
		boolean isMatch = false;

		while (firstStringIndex <= s1.length() - 1 && secondStringIndex <= s2.length() - 1) {

			if (s1.charAt(firstStringIndex) == s2.charAt(secondStringIndex)) {
				firstStringIndex++;
				secondStringIndex++;
			} else {
				secondStringIndex++;
			}

			if (firstStringIndex == s1.length()) {
				System.out.println("Found !!");
				isMatch = true;
				break;
			}
		}
		if (!isMatch) {
			System.out.println("Not Match");
		}

	}

}
