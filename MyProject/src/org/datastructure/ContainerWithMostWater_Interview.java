package org.datastructure;

public class ContainerWithMostWater_Interview {
	public static void main(String[] args) {
		int[] height = { 2, 9, 1, 4, 7, 8 };
		// int[] height = {2,5,6,1,9,7};
		System.out.println("Result " + maxArea(height));
	}

	public static int maxArea(int[] height) {
		int l = 0;
		int r = height.length - 1;
		int res = 0;

		while (l < r) {
			// Calculate area with current pointers
			// Width is r-l, height is min of the two heights
			res = Math.max(res, Math.min(height[l], height[r]) * (r - l));

			// Move pointer with smaller height inward
			if (height[l] < height[r]) {
				l++;
			} else {
				r--;
			}
		}
		return res;
	}
}
