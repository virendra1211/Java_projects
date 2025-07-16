package vk.learning.algo;

import java.util.Arrays;

public class ThreeSumProblem {
	public static void main(String[] args) {

		/*
		 * int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 }; int intsubArray = 3;
		 * 
		 */
		int[] arr = { 5, -1, 2, 9, 3, -2 };
		int intsubArray = 6;

		System.out.println(maxSumSubArray(arr, intsubArray));
	}

	public static int maxSumSubArray(int[] arr, int subArraySize) {
		if (arr.length < subArraySize) {
			throw new IllegalArgumentException("Subarray size is larger than the array size");
		}
		int maxSum = 0;
		int windowSum = 0;
		int maxStartIndex = 0;
		// Calculate the sum of the first window
		for (int i = 0; i < subArraySize; i++) {
			windowSum += arr[i];
		}
		maxSum = windowSum;

		// Slide the window over the array
		for (int i = subArraySize; i < arr.length; i++) {
			windowSum += arr[i] - arr[i - subArraySize];
			System.out.println(i + "- " + (i - subArraySize));
			if (windowSum > maxSum) {
				maxSum = windowSum;
				maxStartIndex = i - subArraySize + 1;
			}
		}

		// Optional: Print subarray
		int[] resultSubarray = Arrays.copyOfRange(arr, maxStartIndex, maxStartIndex + subArraySize);
		System.out.println("Subarray with max sum: " + Arrays.toString(resultSubarray));
		System.out.println("Starts at index: " + maxStartIndex);
		return maxSum;
	}
}
