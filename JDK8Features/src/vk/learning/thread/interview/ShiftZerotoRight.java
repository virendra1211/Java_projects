package vk.learning.thread.interview;

import java.util.Arrays;

public class ShiftZerotoRight {
	public static void main(String[] args) {

		int arr[] = { 1, 2, 4, 0, 9, 5, 0, 0, 7, 0, 8 }; // -> [1, 2, 4, 9, 5, 7, 8, 0, 0, 0, 0]
		simplWay(arr);
		int arr1[] = { 1, 2, 4, 0, 9, 5, 0, 0, 7, 0, 10 };
		moveZeroes(arr1);
		System.out.println(Arrays.toString(arr1));
	}

	private static void simplWay(int[] arr) {
		// int[] arr = { 0, 1, 0, 3, 12 };
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				arr[count++] = arr[i];
			}
		}

		while (count < arr.length) {
			arr[count++] = 0;
		}
		System.out.println(Arrays.toString(arr));
	}

	public static void moveZeroes(int[] arr) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				if (i != count) { // avoid unnecessary self-assignments
					arr[count] = arr[i];
					arr[i] = 0;
				}
				count++;
			}
		}

	}
}
