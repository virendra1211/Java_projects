package vk.learning.thread.interview.bank;

public class RewardService {
	public Rewards getRewards(int id) {
		sleep(700);
		return new Rewards(1200, 35.0, "Gold");
	}

	private void sleep(long ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException ignored) {
		}
	}
}
