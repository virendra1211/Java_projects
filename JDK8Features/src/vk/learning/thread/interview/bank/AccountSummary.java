package vk.learning.thread.interview.bank;

import java.util.List;

public class AccountSummary {
	private String accountNumber;
	private String type;
	private double balance;
	private List<Transaction> recentTransactions;
	private int points;
	private double cashback;
	private String tier;

	public AccountSummary(Account acc, List<Transaction> txns, Rewards rewards) {
		this.accountNumber = acc.getAccountNumber();
		this.type = acc.getType();
		this.balance = acc.getBalance();
		this.recentTransactions = txns;
		this.points = rewards.getPoints();
		this.cashback = rewards.getCashback();
		this.tier = rewards.getTier();
	}

	@Override
	public String toString() {
		return "AccountSummary [accountNumber=" + accountNumber + ", type=" + type + ", balance="
				+ balance + ", recentTransactions=" + recentTransactions + ", points=" + points
				+ ", cashback=" + cashback + ", tier=" + tier + "]";
	}
}
