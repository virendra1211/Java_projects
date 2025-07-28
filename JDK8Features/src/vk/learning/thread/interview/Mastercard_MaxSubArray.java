package vk.learning.thread.interview;

public class Mastercard_MaxSubArray {

	public static void main(String[] args) {
		int[] arr = { -2, -3, 4, -1, -2, 1, 5, -3 };
		maxSubArray(arr);
		System.out.println(" ------------------ ");

		int[] arr2 = { 1, -2, 1, 1, -2, 1 };
		maxSubArray(arr2);
	}

	private static void maxSubArray(int[] arr) {
		int currentMax = arr[0];
		int maxSoFar = arr[0];
		int start = 0;
		int end = 0;
		int tempstart = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > currentMax + arr[i]) {
				currentMax = arr[i];
				tempstart = i;
			} else {
				currentMax += arr[i];
			}

			if (currentMax > maxSoFar) {
				maxSoFar = currentMax;
				start = tempstart;
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
		System.out.println("max so far " + maxSoFar);
		System.out.println("Length of the subarray is: " + (end - start + 1));

	}

}
