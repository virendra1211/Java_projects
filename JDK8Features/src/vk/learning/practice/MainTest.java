package vk.learning.practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainTest {
	public static void main(String[] args) {
		int a1[] = { 1, 1, 0, 1, 1, 1, 0, 0, 0 };
		int a[] = { 1, 1, 0, 2, 2, 1, 0, 2, 0 };

		List<Integer> result = Arrays.stream(a1).boxed().sorted().collect(Collectors.toList());
		/*
		 * System.out.println(result); bubleSort(a);
		 */
		MainTest obj = new MainTest();
		int length = a.length;
		obj.quickSortRecursion(a, 0, length - 1);
		System.out.println(Arrays.toString(a));

	}

	static void bubleSort(int[] a) {
		int n = a.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (a[j] > a[j + 1]) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}

		System.out.println(Arrays.toString(a));

	}

	public void quickSortRecursion(int[] arr, int low, int high) {
		int pi = partition(arr, low, high);

		// left
		if (low < pi - 1) {
			quickSortRecursion(arr, low, pi - 1);
		}
		if (pi < high) {
			quickSortRecursion(arr, pi, high);
		}
		// right

	}

	public int partition(int[] arr, int low, int high) {
		int pivot = arr[(low + high) / 2];

		while (low <= high) {
			if (arr[low] < pivot) {
				low++;
			}
			if (arr[high] > pivot) {
				high--;
			}

			if (low <= high) {
				int temp = arr[low];
				arr[low] = arr[high];
				arr[high] = temp;
				low++;
				high--;
			}

		}

		return low;

	}

}
