package vk.learning.array.tough.interview;

import java.util.HashSet;
import java.util.Set;

/*
 * 1. Sure! Based on the image, you're asked to implement a Java function to find the **length of the
 *  longest consecutive sequence** in an **unsorted array**. You're **not allowed to sort the array**, and must use only 
 *  **Java collections like **`**HashMap**` ** or **`**HashSet**` , and the solution must handle **negative numbers** and
 *   **duplicates**.Here's a clean and efficient Java solution using `HashSet` 
 */
public class ArraySequenceMaxCount {

	private static int longestConsecutive(int[] input) {
		int longestSequenceLength = 0;
		Set<Integer> set = new HashSet<>();
		// no termination, just check the max only,
		for (int num : input) {
			set.add(num);
		}

		for (int num : input) {
			if (!set.contains(num - 1)) {
				int count = 1;
				int concurrentNum = num;
				while (set.contains(concurrentNum + 1)) {
					count++;
					concurrentNum++;
				}
				longestSequenceLength = Math.max(count, longestSequenceLength);
			}

		}

		return longestSequenceLength;
	}

	public static void main(String[] args) {
		int[] input1 = { 100, 4, 200, 1, 3, 2 };
		int[] input2 = { 10, 5, 12, 6, 1, 11, 7 };
		int[] input3 = { -1, -2, -3, 0, 1 };

		System.out.println("Output1: " + longestConsecutive(input1)); // 4
		System.out.println("Output2: " + longestConsecutive(input2)); // 3
		System.out.println("Output3: " + longestConsecutive(input3)); // 5
	}

}
