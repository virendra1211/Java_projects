package org.algoquestion.leetcode;

import java.util.stream.IntStream;

public class BinarySearchForHalfSortRotation {

	public static void main(String[] args) {
		Integer p[] = { 1, 6, 7, 12, 13, 16, 19, 22, 25, 27, 29, 33, 36, 38 };

		// Arrays.sort(p, Collections.reverseOrder());
		// Integer p[] = { 10, 9, 8, 7, 1, 2, 3, 4 };
		binarySearch(0, p.length - 1, 19, p);
		// half sorted
		// Integer[] p1 = { 11, 10, 9, 8, 7, 1, 2, 3, 4 };
		binarySearchForHalf();
	}

	private static void binarySearchForHalf() {
		Integer[] p1 = { 5, 6, 7, 8, 9, 10, 1, 2, 3 };
		// Integer[] p1 = { 22, 21, 19, 18, 5, 6, 7 };
		int target = 3;
		Integer result = IntStream.range(0, p1.length).filter(g -> g == target).findFirst()
				.orElse(-1); // wrong
		System.out.println("********* index " + result);

		int pivot = findPivotLog(p1);
		if (p1[pivot] == target) {
			System.out.println("found in " + pivot);
			return;
		}
		int index = binarySearchDescending(p1, 0, pivot - 1, target);
		if (index == -1) {
			index = binarySearchAscending(p1, pivot, p1.length - 1, target);
		}

		if (index != -1) {
			System.out.println("Found " + target + " at index " + index);
		} else {
			System.out.println(target + " not found");
		}
	}

	private static void binarySearch(int li, int hi, int item, Integer[] p) {
		int mi = (li + hi) / 2;

		while (li <= hi) {

			if (p[mi] == item) {
				System.out.println("Found the index position " + mi + " for " + item);
				break;
			} else if (p[mi] < item) { // 5 <8
				li = mi + 1;
			} else {

				hi = mi - 1;
			}
			mi = (li + hi) / 2;

		}
	}

	private static int binarySearchDescending(Integer[] arr, int low, int high, int target) {
		while (low <= high) {
			int mid = (low + high) / 2;

			if (arr[mid] == target)
				return mid;
			else if (arr[mid] < target)
				high = mid - 1;
			else
				low = mid + 1;
		}
		return -1;
	}

	private static int binarySearchAscending(Integer[] arr, int low, int high, int target) {
		while (low <= high) {
			int mid = (low + high) / 2;
			if (arr[mid] == target)
				return mid;
			else if (arr[mid] > target)
				high = mid - 1;
			else
				low = mid + 1;
		}
		return -1;
	}

	private static int findPivotLog(Integer[] arr) {
		int low = 0, high = arr.length - 1;

		while (low < high) {
			if (arr[low] <= arr[high])
				return low;

			int mid = (low + high) / 2;

			if (arr[mid] > arr[high]) {
				// We are in the descending part
				low = mid + 1;
			} else {
				// We are in ascending part
				high = mid;
			}
		}

		return low; // Index of minimum (pivot)
	}

}
