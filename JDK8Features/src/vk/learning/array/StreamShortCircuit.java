package vk.learning.array;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamShortCircuit {
	public static void main(String[] args) {
		int[] arr = { 2, 4, 6, 7, 8, 10 };
// ** 1. take while and do while short circuit intermediate, skip, limit
		List<Integer> resultTakeWhile = Arrays.stream(arr).takeWhile(n -> n % 2 == 0).boxed()
				.collect(Collectors.toList());
		System.out.println("even and break when odd " + resultTakeWhile);

		List<Integer> dropWhile = Arrays.stream(arr).dropWhile(n -> n % 2 == 0).boxed()
				.collect(Collectors.toList());
		System.out.println(dropWhile);
		shortCircuiteTerminal();
		System.out.println(" ======= ");
		List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6);

		boolean result = nums.stream().peek(n -> System.out.println("Checking: " + n)).filter(n -> n > 2)
				.anyMatch(n -> n % 2 == 0);

		System.out.println("Result: " + result);

	}

	public static void shortCircuiteTerminal() {
		// 1. findFirst()
		List<String> names = Arrays.asList("Tom", "Jack", "Jane", "Jill");
		String firstJ = names.stream().filter(n -> n.startsWith("J")).findFirst().orElse("No match");
		System.out.println(firstJ);
		// 2. find Any
		List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
		Integer anyEven = nums.parallelStream().filter(n -> n % 2 == 0).findAny().orElse(-1); // could be 2 or
																								// 4
		// 3. anyMatch, stops at first match
		List<Integer> numbers = Arrays.asList(1, 3, 5, 6, 7);

		boolean hasEven = numbers.stream().peek(n -> System.out.println("Checking: " + n))
				.anyMatch(n -> n % 2 == 0);

		// 4. allMatch, 👉 Stops at first failure.
		List<Integer> nums1 = Arrays.asList(2, 4, 6, 9, 10);

		boolean allEven = nums1.stream().peek(n -> System.out.println("Checking: " + n))
				.allMatch(n -> n % 2 == 0);

		System.out.println(allEven); // false // Stops at 9, doesn’t check 10.

		// 5. nonMatch, stops at firstMatch
		names.stream().noneMatch(p -> p.startsWith("z")); // efficient as first value doesnt have that start
															// char,

		// 6.

	}
}
