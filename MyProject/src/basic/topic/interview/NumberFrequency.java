package basic.topic.interview;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NumberFrequency {
	public static void main(String[] args) {
		// Step 1: Define the stream with duplicates based on frequency
		List<Integer> numbers = Stream
				.of(Collections.nCopies(5, 1), Collections.nCopies(3, 2), Collections.nCopies(2, 3),
						Collections.nCopies(5, 4), Collections.nCopies(4, 5))
				.flatMap(List::stream).collect(Collectors.toList());

		// Step 2: Print unique numbers
		System.out.println("Unique numbers:");
		numbers.stream().distinct().forEach(System.out::println);

		// Step 3: Count frequency of each number
		System.out.println("\nFrequency of each number:");
		Map<Integer, Long> freqMap = numbers.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		freqMap.forEach((num, count) -> System.out.println(num + " -> " + count));
	}
}
