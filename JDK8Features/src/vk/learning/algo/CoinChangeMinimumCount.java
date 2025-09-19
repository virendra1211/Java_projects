package vk.learning.algo;

public class CoinChangeMinimumCount {
	public static void main(String[] args) {
		int amount = 18;
		int[] coins = { 1, 5, 7, 9 };
		int result = minimumCount(amount, coins);
		System.out.println(result);
	}

	private static int minimumCount(int amount, int[] coins) {

		if (amount == 0)
			return 0;

		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < coins.length; i++) {
			if (amount - coins[i] >= 0) {
				int subAns = minimumCount((amount - coins[i]), coins);
				if (subAns != Integer.MAX_VALUE && subAns + 1 < ans) {
					ans = subAns + 1;
				}
			}
		}
		return ans;

	}
}
