package vk.learning.string;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MergeArray {

	public static void main(String[] args) {
		int[][] array2D = { { 0, 1 }, { 1, 3 }, { 4, 2 } };

		int[] mergedArray = Arrays.stream(array2D).flatMapToInt(Arrays::stream).toArray();
		System.out.println(Arrays.toString(mergedArray));

		int[] array1 = { 1, 2, 3, 0, 0, 0 };
		int m = 3;
		int[] array2 = { 2, 5, 6 };

		// Stream.concat(Arrays.stream(array1),
		// Arrays.stream(array2)).toArray(String[]::new);

		int[] result = IntStream.concat(Arrays.stream(array1), Arrays.stream(array2))
				.filter(p -> p != 0).sorted().toArray();
		System.out.println(Arrays.toString(result));

	}
}
