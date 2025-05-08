package vk.learning.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CoinChangeProblemDynamic {

	public static void main(String[] args) {
		int n = 18;
		int a[] = { 7, 5, 1 };

		int dp[] = new int[n + 1];
		Arrays.fill(dp, -1);
		dp[0] = 0;

		int ans = minCoins(n, a, dp);
		System.out.println(ans);
		for (int x : dp) {
			System.out.print(x + " ");
		}
		/** II nd approach **/
		List<List<Integer>> result = new ArrayList<>();
		Integer aa[] = { 7, 5, 1 };
		Arrays.sort(aa, Collections.reverseOrder()); // optional: helps with ordered output
		findCombinations(n, a, new ArrayList<>(), result, 0);

		for (List<Integer> combination : result) {
			System.out.println("- " + combination);
		}

	}

	static int minCoins(int n, int a[], int dp[]) {
		if (n == 0)
			return 0;

		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < a.length; i++) {
			if (n - a[i] >= 0) {
				// here find out if sub ans already exist
				int subAns = 0;
				if (dp[n - a[i]] != -1) {
					subAns = dp[n - a[i]];
				} else {
					subAns = minCoins(n - a[i], a, dp);
				}
				// end dynamic programming to not do calculation again

				if (subAns != Integer.MAX_VALUE && subAns + 1 < ans) {
					ans = subAns + 1;
				}
			}
		}
		return dp[n] = ans;
	}

	// below method is used to find out the combination
	static void findCombinations(int target, int[] coins, List<Integer> current,
			List<List<Integer>> result, int start) {
		if (target == 0) {
			result.add(new ArrayList<>(current));
			return;
		}

		for (int i = start; i < coins.length; i++) {
			if (coins[i] <= target) {
				current.add(coins[i]);
				findCombinations(target - coins[i], coins, current, result, i);
				current.remove(current.size() - 1); /* allow reuse of same coin */
			}
		}
	}
}
