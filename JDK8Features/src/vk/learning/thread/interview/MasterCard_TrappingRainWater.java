package vk.learning.thread.interview;

public class MasterCard_TrappingRainWater {
	public static void main(String[] args) {
		int[] heights = { 10, 2, 8, 6, 4, 7 };
		int trappedWater = trap(heights);
		System.out.println("Total Trapped Water: " + trappedWater); // Output: 10
	}

	public static int trap(int[] height) {
		int n = height.length;
		if (n == 0)
			return 0;

		int[] leftMax = new int[n];
		int[] rightMax = new int[n];
		int water = 0;

		// Step 1: fill leftMax
		leftMax[0] = height[0];
		for (int i = 1; i < n; i++) {
			leftMax[i] = Math.max(leftMax[i - 1], height[i]);
		}

		// Step 2: fill rightMax
		rightMax[n - 1] = height[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			rightMax[i] = Math.max(rightMax[i + 1], height[i]);
		}

		// Step 3: calculate trapped water
		for (int i = 0; i < n; i++) {
			water += Math.min(leftMax[i], rightMax[i]) - height[i];
		}

		return water;
	}
}
