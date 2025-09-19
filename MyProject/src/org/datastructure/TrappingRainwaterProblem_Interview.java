package org.datastructure;

import java.util.Arrays;

public class TrappingRainwaterProblem_Interview {
	public static void main(String[] args) {
		// int[] heights = { 10, 2, 8, 6, 4, 7 };
		//int[] heights = { 3, 0, 2, 0, 4 }; // 7
		int[] heights = {2,9,1,4,7,8};
		// int[] heights = {3, 0, 1, 0, 4, 0, 2} ; // 10

		int n = heights.length;
		int[] left = new int[n];
		int[] right = new int[n];
		left[0] = heights[0];
		for (int i = 1; i < n; i++) {
			left[i] = Math.max(heights[i], left[i - 1]);
		}
		System.out.println(Arrays.toString(left));

		right[n - 1] = heights[n - 1];

		for (int i = n - 2; i >= 0; i--) {
			right[i] = Math.max(right[i + 1], heights[i]);
		}
		System.out.println(Arrays.toString(right));

		int water = 0;
		for (int i = 0; i < n; i++) {
			water += (Math.min(left[i], right[i])) - heights[i];
		}

		System.out.println(water);

	}
}
