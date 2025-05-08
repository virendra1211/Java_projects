package vk.learning.thread.interview.bank;

public class Account {
	private String accountNumber;
	private String type;
	private double balance;

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Account(String accountNumber, String type, double balance) {
		super();
		this.accountNumber = accountNumber;
		this.type = type;
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

}
