package vk.learning.thread.interview.bank;

public class Transaction {
	private String date;
	private String description;
	private double amount;

	public String getDate() {
		return date;
	}

	public Transaction(String date, String description, double amount) {
		super();
		this.date = date;
		this.description = description;
		this.amount = amount;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}
