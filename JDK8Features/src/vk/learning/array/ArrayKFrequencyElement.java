package vk.learning.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayKFrequencyElement {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 3, 4, 4, 4 };
		int k = 2;
		topKElement(nums, k);
		// other programs
		int nth = 3;
		findThirdHighest(nth);
	}

	private static void findThirdHighest(int nth) {
		Integer[] numbers = { 8, 9 };
		// 47 , 34 , 19

		// first approach
		Integer result = Arrays.stream(numbers).sorted(Comparator.reverseOrder()) // Sort
																					// descending
				.collect(Collectors.collectingAndThen(Collectors.toList(), list -> {
					if (nth > 0 && nth <= list.size()) {
						return list.get(nth - 1); // nth highest
					} else {
						return Collections.min(list); // fallback: lowest
					}
				}));

		System.out.println(result);

		int res = Arrays.stream(numbers).sorted(Comparator.reverseOrder()).skip(nth - 1).findFirst()
				.orElseGet(() -> Collections.min(Arrays.stream(numbers).toList()));

		System.out.println("** " + res);

	}

	private static void topKElement(int[] nums, int k) {

		Map<Integer, Long> map = IntStream.of(nums).boxed()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(map);

		Map<Integer, Long> result = map.entrySet().stream()
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (o, n) -> o,
						LinkedHashMap::new))
				.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.limit(k).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

		System.out.println(result);
		List<Integer> list = new ArrayList<>(result.keySet());

		int p[] = list.stream().mapToInt(Integer::intValue).toArray();
	}

}
