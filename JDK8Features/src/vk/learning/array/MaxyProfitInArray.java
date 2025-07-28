package vk.learning.array;

public class MaxyProfitInArray {
	public static void main(String[] args) {
		Integer[] prices = { 7, 1, 5, 3, 6, 4 };
		System.out.println("Max Profit: " + maxProfit(prices)); // Output: 5

		System.out.println("Max Profit: " + maxProfitMultipleTransactions(prices)); // Output: 5

		int[] prices1 = { 3, 3, 5, 0, 0, 3, 1, 4 };
		System.out.println("## max profit " + maxProfit(prices1));

		int[] prices11 = { 1, 3, 2, 8, 4, 9 };
		int fee = 2;
		totalProfitByAddingTransactionfee(prices11, fee);
		System.out.println("Max Profit: " + totalProfitByAddingTransactionfee(prices11, fee)); // Output:
																								// 8

	}

	/**
	 * You are given an array prices[] where prices[i] is the price of a stock on
	 * day i. You may complete as many transactions as you like (buy and sell
	 * multiple times), but you pay a transaction fee for every sell.
	 * 
	 * Your goal: Maximize total profit after accounting for transaction fees.
	 */
	private static int totalProfitByAddingTransactionfee(int[] prices, int fee) {
		int cash = 0; // Max profit with 0 stock in hand
		int hold = -prices[0]; // Max profit with 1 stock in hand

		for (int i = 1; i < prices.length; i++) {
			cash = Math.max(cash, hold + prices[i] - fee); // sell
			hold = Math.max(hold, cash - prices[i]); // buy
		}

		return cash;

	}

	private static int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0)
			return 0;

		int n = prices.length;
		int[] leftProfit = new int[n];
		int[] rightProfit = new int[n];

		// Left pass
		int minPrice = prices[0];
		for (int i = 1; i < n; i++) {
			minPrice = Math.min(minPrice, prices[i]);
			leftProfit[i] = Math.max(leftProfit[i - 1], prices[i] - minPrice);
		}

		// Right pass
		int maxPrice = prices[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			maxPrice = Math.max(maxPrice, prices[i]);
			rightProfit[i] = Math.max(rightProfit[i + 1], maxPrice - prices[i]);
		}

		// Combine profits
		int maxProfit = 0;
		for (int i = 0; i < n; i++) {
			maxProfit = Math.max(maxProfit, leftProfit[i] + rightProfit[i]);
		}

		return maxProfit;

	}

	public static int maxProfit(Integer[] prices) {
		int minPrice = Integer.MAX_VALUE;
		int maxProfit = 0;
		for (int price : prices) {
			if (price < minPrice) {
				minPrice = price;
			} else if ((price - minPrice) > maxProfit) {
				maxProfit = price - minPrice;
			}

		}

		return maxProfit;
	}

	public static int maxProfitMultipleTransactions(Integer[] prices) {
		int profit = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > prices[i - 1]) {
				profit += prices[i] - prices[i - 1];
			}
		}
		return profit;
	}
}
