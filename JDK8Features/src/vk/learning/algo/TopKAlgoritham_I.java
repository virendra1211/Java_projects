package vk.learning.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
 * Given an array arr[] and an integer k, the task is to find k largest elements in 
 * the given array. Elements in the output array should be in decreasing order.
 * o(n logn) to o(n*log(k))
 */
public class TopKAlgoritham_I {
	/*
	 * Input: [1, 23, 12, 9, 30, 2, 50], k = 3 Output: [50, 30, 23]
	 * 
	 * Input: [11, 5, 12, 9, 44, 17, 2], k = 2 Output: [44, 17]
	 */
	public static void main(String[] args) {
		int[] arr = { 1, 23, 12, 9, 30, 2, 50 };
		int k = 3;
		ArrayList<Integer> res = kLargest(arr, k);
		for (int ele : res)
			System.out.print(ele + " ");
		System.out.println();
		System.out.println(res.stream().reduce(0, (a, b) -> a + b));

	}

	static ArrayList<Integer> kLargest(int[] arr, int k) {
		int n = arr.length;

		// Convert int type to Integer
		// for sorting with a comparator
		Integer[] arrInteger = Arrays.stream(arr).boxed().toArray(Integer[]::new);

		// Sort the array in descending order
		Arrays.sort(arrInteger, Collections.reverseOrder());

		// Store the first k elements in result list
		ArrayList<Integer> res = new ArrayList<>();
		for (int i = 0; i < k; i++)
			res.add(arrInteger[i]);

		return res;
	}
}
