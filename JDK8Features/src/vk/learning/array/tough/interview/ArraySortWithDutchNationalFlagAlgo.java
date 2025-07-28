package vk.learning.array.tough.interview;

import java.util.Arrays;

// dutch national flag algo
public class ArraySortWithDutchNationalFlagAlgo {
	public static void main(String[] args) {
		int[] a = { 1, 1, 0, 2, 2, 1, 0, 2, 0 };
		int low = 0, mid = 0, high = a.length - 1;

		while (mid <= high) {
			switch (a[mid]) {
			case 0 -> {
				// Swap a[low] and a[mid]
				int temp = a[low];
				a[low] = a[mid];
				a[mid] = temp;
				low++;
				mid++;
			}
			case 1 -> mid++; // No swap needed, just move mid
			case 2 -> {
				// Swap a[mid] and a[high]
				int temp = a[mid];
				a[mid] = a[high];
				a[high] = temp;
				high--;
			}
			}
		}

		System.out.println("Sorted Array: " + Arrays.toString(a));
	}
}
