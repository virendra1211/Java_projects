package vk.java8.stream.problems;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamBestInterviewQuestion {

	static void takeTansaction() {
		// List of Transactions
		List<Transaction> transactions = List.of(new Transaction("USD", "BUY", 100.0),
				new Transaction("USD", "BUY", 200.0), new Transaction("USD", "SELL", 300.0),
				new Transaction("EUR", "BUY", 150.0), new Transaction("EUR", "SELL", 250.0),
				new Transaction("EUR", "SELL", 350.0), new Transaction("INR", "DEPOSIT", 1000.0),
				new Transaction("INR", "WITHDRAWAL", 500.0),
				new Transaction("INR", "DEPOSIT", 2000.0));

		Map<String, Map<String, Double>> result = transactions.stream()
				.collect(Collectors.groupingBy(Transaction::getCurrency, Collectors.groupingBy(
						Transaction::getType, Collectors.averagingDouble(Transaction::getAmount))));

		for (Map.Entry<String, Map<String, Double>> currencyEntry : result.entrySet()) {
			String currency = currencyEntry.getKey();
			System.out.println("Currency: " + currency);
			for (Map.Entry<String, Double> typeEntry : currencyEntry.getValue().entrySet()) {
				String type = typeEntry.getKey();
				Double avgAmount = typeEntry.getValue();
				System.out.printf("  Type: %s, Average Amount: %.2f%n", type, avgAmount);
			}
		}
		int[] p = { 1, 0, 1, 0, 1 };
		System.out.println("======== ");
		Map<Boolean, List<Integer>> map = IntStream.of(p).boxed()
				.collect(Collectors.partitioningBy(g -> g == 1));
		map.forEach((k, v) -> {
			System.out.println(k);
			v.forEach(System.out::println);
		});

	}

	static void teeingMultipleValue() {
		List<Employee> employees = Arrays.asList(new Employee("Amit", 60000),
				new Employee("Neha", 75000), new Employee("Ravi", 50000),
				new Employee("Priya", 80000));

		// Teeing: sum and average together
		Map<String, Double> summary = employees.stream()
				.collect(Collectors.teeing(Collectors.summingInt(Employee::getSalary),
						Collectors.averagingInt(Employee::getSalary), (sum, avg) -> {
							return Map.of("Total Salary", sum.doubleValue(), "Average Salary", avg);
						}));

		long count = employees.stream().count(); // get count separately

		// Print result
		System.out.println("Employee Count   : " + count);
		System.out.println("Total Salary     : ₹" + summary.get("Total Salary"));
		System.out.println("Average Salary   : ₹" + summary.get("Average Salary"));

	}

	public static void main(String[] args) {
		takeTansaction();
		otherWay();
		List<Item> items = Arrays.asList(new Item("apple", 10, new BigDecimal("9.99")),
				new Item("banana", 20, new BigDecimal("19.99")),
				new Item("orang", 10, new BigDecimal("29.99")),
				new Item("watermelon", 10, new BigDecimal("29.99")),
				new Item("papaya", 20, new BigDecimal("9.99")),
				new Item("apple", 10, new BigDecimal("9.99")),
				new Item("banana", 10, new BigDecimal("19.99")),
				new Item("apple", 20, new BigDecimal("9.99")));

		Map<String, String> summary = items.stream().collect(Collectors.groupingBy(Item::getName,
				Collectors.collectingAndThen(Collectors.toList(), itemList -> {
					int totalQty = itemList.stream().mapToInt(Item::getQuantity).sum();
					BigDecimal totalPrice = itemList.stream()
							.map(i -> i.getPrice().multiply(BigDecimal.valueOf(i.getQuantity())))
							.reduce(BigDecimal.ZERO, BigDecimal::add);
					return totalQty + " : " + totalPrice;
				})));

		System.out.println("Result " + summary);

		Map<String, List<Item>> itemsMap = items.stream()
				.collect(Collectors.groupingBy(Item::getName));
		System.out.println(itemsMap);

		// 1 . Group by Item name and display count
		Map<String, Long> map = items.stream()
				.collect(Collectors.groupingBy(Item::getName, Collectors.counting()));

		// Extra question, quantity average cost
		Map<String, Double> mapAverageCost = items.stream().collect(
				Collectors.groupingBy(Item::getName, Collectors.averagingInt(Item::getQuantity)));

		System.out.println("*** " + map);
		// 2. Group by Item name and show total Qty
		Map<String, Integer> mapWithQuantity = items.stream().collect(
				Collectors.groupingBy(Item::getName, Collectors.summingInt(Item::getQuantity)));
		System.out.println(mapWithQuantity);

		// 3. Group by Price and return result in Hashset

		Map<BigDecimal, Set<Item>> mapWithPrice = items.stream().collect(
				Collectors.groupingBy(Item::getPrice, Collectors.toCollection(HashSet::new)));
		System.out.println(">>> " + mapWithPrice);

		// Question 4 - How will you group by name & qty both
		Map<NameQtyKey, List<Item>> grouped = items.stream().collect(
				Collectors.groupingBy(item -> new NameQtyKey(item.getName(), item.getQuantity())));

		System.out.println(" =============== group by ========= ");
		grouped.forEach((key, itemList) -> {
			System.out.println(key + " -> " + itemList.size() + " items");
			itemList.forEach(item -> System.out.println("  " + item));
		});

		System.out.println(mapWithPrice);

		Map<String, Double> mapWithPrice1 = items.stream().collect(Collectors.groupingBy(
				Item::getName, Collectors.averagingDouble(p -> p.getPrice().doubleValue())));
		System.out.println("averagging double" + mapWithPrice1);

		System.out.println(" =================== ");

	}

	private static void otherWay() {
		List<Item1> list = Arrays.asList(new Item1("Apple", 10, 20), new Item1("Apple", 5, 12),
				new Item1("banana", 2, 5));
		Map<String, Integer> result = list.stream().collect(Collectors.groupingBy(Item1::getName,
				Collectors.summingInt(p -> p.getPrice() * p.getQtry())));
		System.out.println(result);

	}

	static class NameQtyKey {
		private String name;
		private int quantity;

		public NameQtyKey(String name, int quantity) {
			this.name = name;
			this.quantity = quantity;
		}

		// equals and hashCode needed for grouping
		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (!(o instanceof NameQtyKey))
				return false;
			NameQtyKey that = (NameQtyKey) o;
			return quantity == that.quantity && Objects.equals(name, that.name);
		}

		@Override
		public int hashCode() {
			return Objects.hash(name, quantity);
		}

		@Override
		public String toString() {
			return "Key{name='" + name + "', qty=" + quantity + '}';
		}
	}

}

class Item {
	private String name;
	private int quantity;
	private BigDecimal price;

	public Item(String name, int quantity, BigDecimal price) {
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}

	// Getters
	public String getName() {
		return name;
	}

	public int getQuantity() {
		return quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	// toString
	@Override
	public String toString() {
		return "Item{" + "name='" + name + '\'' + ", quantity=" + quantity + ", price=" + price
				+ '}';
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, price, quantity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return Objects.equals(name, other.name) && Objects.equals(price, other.price)
				&& quantity == other.quantity;
	}

}

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

class TransactionGroup {
	private String currency;
	private String type; // "BUY", "SELL", "DEPOSIT", "WITHDRAWAL"

	public TransactionGroup(String currency, String type) {
		this.currency = currency;
		this.type = type;
	}

	public String getCurrency() {
		return currency;
	}

	public String getType() {
		return type;
	}

}

class Item1 {
	String name;

	public Item1(String name, int qtry, int price) {
		super();
		this.name = name;
		this.qtry = qtry;
		this.price = price;
	}

	int qtry;
	int price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQtry() {
		return qtry;
	}

	public void setQtry(int qtry) {
		this.qtry = qtry;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
