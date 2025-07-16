package vk.learning.important.interview;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Transaction {
	private String currency;
	private String type; // "BUY", "SELL", "DEPOSIT", "WITHDRAWAL"
	private double amount;

	public Transaction(String currency, String type, double amount) {
		this.currency = currency;
		this.type = type;
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public String getType() {
		return type;
	}

	public double getAmount() {
		return amount;
	}
}

/*
 * Input:- Given a list of Transaction objects, how can I group the transactions
 * first by currency and then by type (e.g., BUY, SELL, DEPOSIT, WITHDRAWAL),
 * and calculate the average amount for each group using Java Streams ...
 * Output:- Currency: USD Type: BUY, Average Amount: 150.0 Type: SELL, Average
 * Amount: 300.0 Currency: EUR Type: BUY, Average Amount: 150.0 Type: SELL,
 * Average Amount: 300.0 Currency: INR Type: DEPOSIT, Average Amount: 1500.0
 * Type: WITHDRAWAL, Average Amount: 500.0
 */

public class TransactionDemo {
	public static void main(String args[]) {
		Map<String, String> map = new HashMap<>();
		for (int i = 1; i < 32; i++) {
			map.put("" + i, "aaa" + i);
		}
		// List of Transactions
		List<Transaction> transactions = List.of(new Transaction("USD", "BUY", 100.0),
				new Transaction("USD", "BUY", 200.0), new Transaction("USD", "SELL", 300.0),
				new Transaction("EUR", "BUY", 150.0), new Transaction("EUR", "SELL", 250.0),
				new Transaction("EUR", "SELL", 350.0), new Transaction("INR", "DEPOSIT", 1000.0),
				new Transaction("INR", "WITHDRAWAL", 500.0),
				new Transaction("INR", "DEPOSIT", 2000.0));

		// Group By Currency
		Map<String, List<Transaction>> currencyMap = transactions.stream().collect(Collectors
				.groupingBy(Transaction::getCurrency, LinkedHashMap::new, Collectors.toList()));
		currencyMap.forEach((k, v) -> {
			System.out.println("Currency: " + k);
			// Group By Type
			Map<String, List<Transaction>> typeMap = v.stream().collect(Collectors
					.groupingBy(Transaction::getType, LinkedHashMap::new, Collectors.toList()));
			typeMap.forEach((key, value) -> {
				double averageAmount = value.stream()
						.collect(Collectors.averagingDouble(Transaction::getAmount));
				System.out.println("    Type: " + key + ", Average Amount:" + averageAmount);
			});
		});

	}
}
