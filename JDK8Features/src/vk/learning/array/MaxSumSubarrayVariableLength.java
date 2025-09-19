package vk.learning.array;

public class MaxSumSubarrayVariableLength {
	public static void main(String[] args) {
		int[] arr1 = { 1, -2, 1, 1, -2, 1 };
		int[] arr2 = { -2, -3, 4, -1, -2, 1, 5, -3 };

		/*
		 * System.out.println("Output 1:"); findMaxSumSubarray(arr1); ``` int[] input1 =
		 * {100, 4, 200, 1, 3, 2}; // 4 int[] input3 = {-1, -2, -3, 0, 1}; // 5 ```
		 * 
		 */
		int p[] = { 2, 5, -5, 1, -6, 4, 2 };
		int p1[] = { 2, 5, -5, 6, 7, 1, 1, -6, 4, 2 };
		System.out.println("\nOutput 2:");
		findMaxSumSubarray(arr1);
		findMaxSumSubarray(arr2);
		findMaxSumSubarray(p1);
		int[] input = { -1, 2, -1, 3, -2, 4 };
		findMaxSumSubarray(input);

	}

	public static void findMaxSumSubarray(int[] arr) {
		int maxSoFar = arr[0];
		int currentMax = arr[0];

		int start = 0, end = 0, tempStart = 0;

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > currentMax + arr[i]) {
				currentMax = arr[i];
				tempStart = i;
			} else {
				currentMax += arr[i];
			}

			if (currentMax > maxSoFar) {
				maxSoFar = currentMax;
				start = tempStart;
				end = i;
			}
		}

		// Output
		System.out.println("Subarray with maximum sum is:");
		System.out.print("{ ");
		for (int i = start; i <= end; i++) {
			System.out.print(arr[i]);
			if (i < end)
				System.out.print(", ");
		}
		System.out.println(" }");

		System.out.println("Maximum Sum: " + maxSoFar);
		System.out.println("Length of the subarray is: " + (end - start + 1));
	}
}
