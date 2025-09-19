package vk.java8.stream.problems;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ED_Question {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 4, 5, 6, 7, 8 };
		System.out.println(binarySearch(arr, 41));
		int sum = sumOnlyEven(arr);
		System.out.println(sum);
		List<Item> items = Arrays.asList(new Item("apple", 5, new BigDecimal(5)),
				new Item("apple", 20, new BigDecimal(20)), new Item("apple", 1, new BigDecimal(1)),
				new Item("banana", 10, new BigDecimal(10)), new Item("banana", 20, new BigDecimal(20)),
				new Item("orange", 60, new BigDecimal(60)), new Item("orange", 20, new BigDecimal(20)));

		Map<String, String> summary = items.stream().collect(Collectors.groupingBy(Item::getName,
				Collectors.collectingAndThen(Collectors.toList(), itemList -> {
					int totalQty = itemList.stream().mapToInt(Item::getQuantity).sum();
					BigDecimal totalPrice = itemList.stream()
							.map(i -> i.getPrice().multiply(BigDecimal.valueOf(i.getQuantity())))
							.reduce(BigDecimal.ZERO, BigDecimal::add);
					return totalQty + " : " + totalPrice;
				})));
		summary.forEach((k, v) -> System.out.println(k + " " + v));

		System.out.println(p()); // finally answer is printed

		generateMaxNumber();
		sumSquareForEven();
		santoshQuestion();
	}

	private static void santoshQuestion() {
		int[] nums = { 1, 2, 3, 3, 4, 4, 4 };
		int k = 2; // min frequency
		System.out.println(findNumbersWithFrequency(nums, k));

		int[] nums1 = { 6 };
		k = 1; // min frequency
		System.out.println(findNumbersWithFrequency(nums1, k));
	}

	private static List<Integer> findNumbersWithFrequency(int[] nums, int minFrequency) {
		if (nums == null || nums.length == 0) {
			System.out.println("Invalid or empty input array");
			return Collections.emptyList();
		}

		return Arrays.stream(nums).boxed()
				.collect(
						Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(entry -> entry.getValue() >= minFrequency).map(Map.Entry::getKey)
				.collect(Collectors.toList());
	}

	private static int sumOnlyEven(int[] arr) {

		int result = Arrays.stream(arr).filter(p -> p % 2 == 0).reduce(0, (a, b) -> a + b);

		return result;
	}

	private static int binarySearch(int[] arr, int item) {
		int low = 0;
		int high = arr.length - 1;

		int mid = (low + high) / 2;

		while (low <= high) {

			if (arr[mid] == item) {
				return mid;
			}
			if (arr[mid] < item) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
			mid = (low + high) / 2;

		}
		return -1;
	}

	private static void sumSquareForEven() {

		// sum of square of even elements in an array using java 8
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		List<Integer> list = Arrays.stream(arr).boxed().filter(p -> p % 2 == 0).map(g -> g * g)
				.collect(Collectors.toList());
		System.out.println(list);
		int sum = Arrays.stream(arr).filter(n -> n % 2 == 0) // Keep only even numbers
				.map(n -> n * n) // Square them
				.sum(); // Sum the squares
		System.out.println(sum);
		generichCheck();

	}

	private static void generichCheck() {
		List<Long> longs = Arrays.asList(12L, 6L, 7L, 34L, 8L, 99L);
		long totalLongs = (long) sum(longs);
		System.out.println("totalLongs: " + totalLongs);

		List<Double> doubles = Arrays.asList(12d, 6d, 7d, 34d, 8d, 99d);
		double totalDoubles = sum(doubles);
		System.out.println("doubles: " + totalDoubles);
	}

	private static <T extends Number> double sum(List<T> list) {
		return list.stream().mapToDouble(Number::doubleValue).sum();
	}

	private static void generateMaxNumber() {
		int arr[] = { 1, 34, 3, 98, 9, 76, 45, 4 };
		// out put should be 998764543431

		// Step 1: Convert to String array

		List<String> list = Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.toList());

		// String[] strArr =
		// Arrays.stream(arr).mapToObj(String::valueOf).toArray(String[]::new);

		// Step 2: Sort using custom comparator
		// Arrays.sort(strArr, (a, b) -> (b + a).compareTo(a + b));
		Collections.sort(list, (a, b) -> (b + a).compareTo(a + b));

		// Step 3: Handle all zeros edge case
		/*
		 * if (strArr[0].equals("0")) { System.out.println("0"); return; }
		 */

		// String result = String.join("", strArr);
		String result = list.stream().collect(Collectors.joining());
		System.out.println(result);
	}

	public static int p() {
		try {
			return 1;
		} finally {
			return 2;
		}
	}
}

interface InterfaceA {
	default String getData() {
		return "Data from A";
	}
}

interface InterfaceB {
	default Object getData() {
		return 123;
	}
}

class MyClass11 implements InterfaceA, InterfaceB {

	@Override
	public String getData() {
		// TODO Auto-generated method stub
		return InterfaceA.super.getData();
	}
	// ❌ Compile-time error: getData() is ambiguous
}