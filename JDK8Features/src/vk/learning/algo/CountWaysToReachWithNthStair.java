package vk.learning.algo;

/*
Count ways to reach the nth stair using step 1, 2 or 3
A child is running up a staircase with n steps and can hop either 1 step, 2 steps, 
or 3 steps at a time. The task is to implement a method to count how many possible ways the child can run up the stairs.

 */
public class CountWaysToReachWithNthStair {
	public static void main(String[] args) {
		int n = 4;
		n = 3;
		System.out.println(countWays(n));
	}

	static int countWays(int n) {
		// base case for 0th stair
		if (n == 0)
			return 1;

		// for invaid stair, return 0
		if (n < 0)
			return 0;

		return countWays(n - 1) + countWays(n - 2) + countWays(n - 3);
	}
}

/*
 * Input: 4 Output: 7 Explanation: There are seven ways: {1, 1, 1, 1}, {1, 2,
 * 1}, {2, 1, 1}, {1, 1, 2}, {2, 2}, {3, 1}, {1, 3}.
 * 
 * 
 * Input: 3 Output: 4 Explanation: There are four ways: {1, 1, 1}, {1, 2}, {2,
 * 1}, {3}.
 */