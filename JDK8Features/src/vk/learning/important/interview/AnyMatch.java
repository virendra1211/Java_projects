package vk.learning.important.interview;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class AnyMatch {

	public static void main(String[] args) {
		List<String> names = Arrays.asList("Bob", "Charlie", "Alex", "David");
		boolean b = names.stream().anyMatch(p -> p.startsWith("A"));
		System.out.println(b);

		Optional<String> found = names.stream().filter(name -> name.startsWith("A")).findFirst();

		found.ifPresent(p -> System.out.println(p));

		String str = "abc3ded5";
		int sum = str.chars() // Stream of int (ASCII)
				.filter(Character::isDigit) // keep only digits
				.map(Character::getNumericValue)
				// .map(c -> c - '0') // convert char digit to number
				.sum(); // sum them

		System.out.println("Sum of digits: " + sum); // Output: 8

	}

}
