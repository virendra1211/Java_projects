package vk.learning.important.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Result {

	/*
	 * Complete the 'mergeArrays' function below.
	 *
	 * The function is expected to return an INTEGER_ARRAY. The function accepts
	 * following parameters: 1. INTEGER_ARRAY a 2. INTEGER_ARRAY b
	 */

	public static List<Integer> mergeArrays(List<Integer> x, List<Integer> y) {
		// Write your code here
		List<Integer> mergeList = new ArrayList<>();
		int[] a = x.stream().mapToInt(Integer::intValue).toArray();
		int[] b = y.stream().mapToInt(Integer::intValue).toArray();

		Integer[] result = new Integer[a.length + b.length];
		int cursor = 0;

		int arrayAIndex = 0;
		int arrayBIndex = 0;

		while (arrayAIndex < a.length && arrayBIndex < b.length) {

			if (a[arrayAIndex] <= b[arrayBIndex]) {
				result[cursor++] = a[arrayAIndex];
				arrayAIndex++;
			} else if (a[arrayAIndex] > b[arrayBIndex]) {
				result[cursor++] = b[arrayBIndex];
				arrayBIndex++;
			}

		}

		if (arrayAIndex < a.length && arrayBIndex >= b.length) {

			while (arrayAIndex < a.length) {
				result[cursor++] = a[arrayAIndex++];

			}
		} else if (arrayBIndex < b.length) {
			while (arrayBIndex < b.length) {
				result[cursor++] = b[arrayBIndex++];
			}
		}
		mergeList.addAll(Arrays.asList(result));

		return mergeList;

	}

}
