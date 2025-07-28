package vk.learning.array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public class ArrayCombinationSumTarget {

	public static int[] getTargetSum(int[] arr, int target) {
		Map<Integer, Integer> map = new WeakHashMap<>();

		for (int i = 0; i < arr.length; i++) {
			int pair = target - arr[i];
			if (map.containsKey(pair)) {
				return new int[] { map.get(pair), i };
			}
			map.put(arr[i], i);
		}

		return new int[] {};
	}

	public static void main(String[] args) {

		// int arr[] = { 1, 2, 3 };

		/*
		 * int arr[] = { 1, 2, 3, 4, 5 }; // int arr[] = { 6, 5, 1, 9 }; int target = 5;
		 * // 19;
		 */
		int arr[] = { -2, 0, 2, 2, -2, 4 };
		int target = 0;
		int[] result = getTargetSum(arr, target);
		System.out.println(result[0] + " - " + result[1]);
		Set<int[]> list1 = new HashSet<>();

		list1.forEach(p -> {
			System.out.println(arr[p[0]] + "- " + arr[p[1]]);
		});
		/*-------------------
		i	arr[i]		map
		0	1			4,0
		1	2			3,1
		2	3
		-------------------*/

		// System.out.println(ARraylist1);

		System.out.println(" ------------------- ");
		List<ArrayList<Integer>> result1 = new ArrayList<>();
		finCombination(arr, target, new ArrayList<Integer>(), result1, 0);
		for (List<Integer> list : result1) {
			System.out.println(list);
		}
		result1.sort(Comparator.comparingInt(List::size));

	}

	private static void finCombination(int[] nums, int target, ArrayList<Integer> current,
			List<ArrayList<Integer>> result, int start) {
		if (target == 0) {
			result.add(new ArrayList<>(current));
			return;
		}
		for (int i = start; i < nums.length; i++) {
			if (target >= nums[i]) {
				current.add(nums[i]);
				// finCombination(nums, target - nums[i], current, result, start + 1); // Allow
				// the
				finCombination(nums, target - nums[i], current, result, i); // Allow the

				// element again
				current.remove(current.size() - 1); // backtrack
			}
		}
	}
	//

}

record Pair(Integer first, Integer second) {
}

record Person3(String name, char gender, int age) {
	public Person3 {
		if (name.isBlank() || age < 1) {
			throw new java.lang.IllegalArgumentException(
					"Name can't be left blank and age should be atleast 1");
		}
	}
}