package vk.learning.thread.interview.bank;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AccountServiceRewadsCall {

	public static void main(String[] args) {
		AccountServiceRewadsCall accountService = new AccountServiceRewadsCall();
		System.out.println(accountService.getSummary(5));
	}

	private AccountService accountService;
	private TransactionService transactionService;
	private RewardService rewardService;
	private final ExecutorService executor = Executors.newFixedThreadPool(3);

	public AccountSummary getSummary(int id) {
		accountService = new AccountService();
		transactionService = new TransactionService();
		rewardService = new RewardService();

		CompletableFuture<Account> accountFuture = CompletableFuture
				.supplyAsync(() -> accountService.getAccount(id), executor);

		CompletableFuture<List<Transaction>> txnFuture = CompletableFuture
				.supplyAsync(() -> transactionService.getRecentTransactions(id), executor);
		/*
		 * fall back based on the below code try { return
		 * loyaltyService.getLoyalty(userId, from + "-" + to); } catch (Exception e) {
		 * System.out.println("LoyaltyService failed: " + e.getMessage()); return new
		 * Loyalty(0, "None"); // fallback }
		 */

		CompletableFuture<Rewards> rewardsFuture = CompletableFuture
				.supplyAsync(() -> rewardService.getRewards(id), executor);

		CompletableFuture.allOf(accountFuture, txnFuture, rewardsFuture).join();

		return new AccountSummary(accountFuture.join(), txnFuture.join(), rewardsFuture.join());
	}

}
