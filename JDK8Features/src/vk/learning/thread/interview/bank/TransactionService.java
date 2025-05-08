package vk.learning.thread.interview.bank;

import java.util.List;

public class TransactionService {
	public List<Transaction> getRecentTransactions(int id) {
		sleep(1000);
		return List.of(new Transaction("2024-05-01", "Coffee", -4.5),
				new Transaction("2024-04-30", "Salary", 3000),
				new Transaction("2024-04-29", "Netflix", -15.99));
	}

	private void sleep(long ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException ignored) {
		}
	}
}
