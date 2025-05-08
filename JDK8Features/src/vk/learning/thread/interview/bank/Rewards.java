package vk.learning.thread.interview.bank;

public class Rewards {
	private int points;
	private double cashback;
	private String tier;

	// Constructor, getters
	@Override
	public String toString() {
		return "Rewards [points=" + points + ", cashback=" + cashback + ", tier=" + tier + "]";
	}

	public Rewards(int points, double cashback, String tier) {
		super();
		this.points = points;
		this.cashback = cashback;
		this.tier = tier;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public double getCashback() {
		return cashback;
	}

	public void setCashback(double cashback) {
		this.cashback = cashback;
	}

	public String getTier() {
		return tier;
	}

	public void setTier(String tier) {
		this.tier = tier;
	}
}
