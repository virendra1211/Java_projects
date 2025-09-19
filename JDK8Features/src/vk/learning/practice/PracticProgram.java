package vk.learning.practice;

public class PracticProgram {
	public static void main(String[] args) {
		Boolean isBoolean = null;

		if (Boolean.TRUE.equals(isBoolean)) {
			System.out.println("Safe check, won't throw NPE.");
		}

		/*
		 * if (isBoolean) { // <-- will throw NullPointerException
		 * System.out.println("This will crash."); }
		 */

		// Problem: Find the Missing Number
		int arr[] = { 1, 2, 4, 5, 6 };
		System.out.println("missing Approach # " + missingNumber(arr));
		System.out.println("missing Approach ## " + findMissing(arr, 6));

		// find max sum of buy sell stock , consequence
		int arr1[] = { 5, 2, 3, 5, 4, 9 }; // ans 1 + 2 + 5 | 1
		System.out.println("maxProfit " + maxProfit(arr1));

		// find sequence of missing number
		int arr2[] = { 2, 4, 6, 8, 12, 14, 16 };
		System.out.println(missingTable(arr2));
	}

	private static int maxProfit(int[] arr) {
		int maxProfit = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i + 1] > arr[i]) {
				maxProfit = maxProfit + (arr[i + 1] - arr[i]);
				i++;
			}
		}
		return maxProfit;
	}

	private static int missingTable(int[] arr) {
		int missingNumber = 0;
		int counter = 0;
		int startSequence = 2;
		int temp = startSequence;
		int myCount = 1;
		// 2X1 = 2 , 2X2 = 4 , 2X3 =6
		while (counter < arr.length - 1) {
			if (!(startSequence == arr[counter])) {
				missingNumber = startSequence;
				break;
			}
			counter++;
			myCount++;
			startSequence = myCount * temp;
		}

		return missingNumber;
	}

	private static int missingNumber(int[] arr) {
		int missingNumber = 0;
		int counter = 0;
		int sequence = 1;

		while (counter < arr.length - 1) {
			if (!(sequence == arr[counter])) {
				missingNumber = sequence;
				break;
			}
			sequence = sequence++;
			counter++;
		}

		return missingNumber;
	}

	// simple and efficient solution for finding missing
	public static int findMissing(int[] arr, int n) {
		int expectedSum = n * (n + 1) / 2;
		int actualSum = 0;
		for (int num : arr) {
			actualSum += num;
		}
		return expectedSum - actualSum;
	}
}
