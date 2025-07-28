package vk.learning.array.tough.interview;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
 * Why CopyOnWriteArrayList behaves differently
	It creates a fresh copy of the entire array on every mutation (add/remove/set).
	So the iterator works on a snapshot copy, and even if you modify, it doesn’t impact that snapshot → no exception.
	CopyOnWriteArrayList uses a ReentrantLock (specifically an intrinsic lock) to guard mutation operations like:
		add()
		remove()
		set()
 */
public class ArrayPracticeQusSolution {
	public static void main(String[] args) {
		findSecondSmallest();
		findDuplicate();
		commonElementinTwoArray();
		reverseArray();
		reverseArrayByStream();
		findTheLongestStream();
		flattenListOfStrings();
		List<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
		// ArrayList<Integer> copyOnWriteArrayList = new ArrayList<>();
		copyOnWriteArrayList.add(1);
		copyOnWriteArrayList.add(2);
		copyOnWriteArrayList.add(3);

		for (Integer val : copyOnWriteArrayList) {
			copyOnWriteArrayList.add(10); // ConcurrentModificationException
			System.out.println("before -- " + copyOnWriteArrayList.get(1));
			copyOnWriteArrayList.set(1, 33);
			System.out.println(copyOnWriteArrayList.size());
			System.out.println(" -- " + copyOnWriteArrayList.get(1));
		}

		/*
		 * for (int i = 0; i < copyOnWriteArrayList.size(); i++) {
		 * 
		 * copyOnWriteArrayList.add(10); // (2, 5);
		 * System.out.println(copyOnWriteArrayList.size());
		 * 
		 * copyOnWriteArrayList.set(2, 134); if (i == 1) copyOnWriteArrayList.add(10);
		 * System.out.println(copyOnWriteArrayList.size());
		 * 
		 * }
		 */
	}

	private static void flattenListOfStrings() {
		List<List<String>> listOfLists = Arrays.asList(Arrays.asList("one", "two"),
				Arrays.asList("three", "four"));

		List<String> result = listOfLists.stream().flatMap(Collection::stream)
				.collect(Collectors.toList());
		System.out.println(result);

	}

	private static void findTheLongestStream() {
		String[] strings = { "Apple", "Banana", "Avocado", "Apricot", "Grapes" };
		String result = Arrays.stream(strings)
				.sorted(Comparator.comparing(String::length).reversed()).findFirst()
				.orElseThrow(() -> new IllegalArgumentException("Not found"));
		System.out.println(" max length String= " + result);

		int maxStringSize = Arrays.stream(strings).mapToInt(str -> str.length()).max().orElse(0);
		System.out.println("------------- " + maxStringSize);
	}

	private static void reverseArrayByStream() {
		int arr[] = { 1, 2, 3, 4, 5 };
		IntStream.range(0, arr.length / 2).forEach(i -> {
			int temp = arr[i];
			arr[i] = arr[arr.length - i - 1];
			arr[arr.length - i - 1] = temp;
		});
	}

	private static void reverseArray() {
		int arr[] = { 1, 2, 3, 4, 5 };
		int left = 0;
		int right = arr.length - 1;
		while (left < right) {
			int temp = arr[right];
			arr[right] = arr[left];
			arr[left] = temp;
			left++;
			right--;
		}
		System.out.println(" --- " + Arrays.toString(arr));
	}

	/*
	 * Given two arrays of integers, write a java 8 program to find the common
	 * elements beteen them
	 */
	private static void commonElementinTwoArray() {
		int[] arr1 = { 1, 2, 3, 4, 5 };
		int[] arr2 = { 4, 5, 6, 7, 8 };
		List<Integer> commonList = Arrays.stream(arr1)
				.filter(num -> Arrays.stream(arr2).anyMatch(num2 -> num == num2)).boxed()
				.collect(Collectors.toList());
		System.out.println("common Element " + Arrays.toString(commonList.toArray()));

	}

	private static void findSecondSmallest() {
		System.out.println(" ----- ");
		int[] arr = { 5, 2, 8, 3, 1, 1 }; // if duplicate
		int secondSmallestElement = Arrays.stream(arr).distinct().skip(1).findFirst()
				.orElseThrow(() -> new IllegalArgumentException("Issue"));

		System.out.println("second Smallest Number " + secondSmallestElement);

	}

	private static void findDuplicate() {
		int[] numArray = { 2, 6, 7, 6, 2, 19, 1, 19 };
		Set<Integer> numSet = new HashSet<Integer>();
		for (int num : numArray) {
			// If add returns false
			if (!numSet.add(num)) {
				System.out.println("Duplicate element found " + num);
			}
		}
	}
}
