package vk.learning.thread.interview.bank;

public class AccountService {
	public Account getAccount(int id) {
		sleep(500);
		return new Account("1234567890", "Savings", 25000.75);
	}

	private void sleep(long ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException ignored) {
		}
	}
}
