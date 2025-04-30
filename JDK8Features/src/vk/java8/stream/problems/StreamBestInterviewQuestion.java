package vk.java8.stream.problems;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamBestInterviewQuestion {

	public static void main(String[] args) {
		List<Item> items = Arrays.asList(new Item("apple", 10, new BigDecimal("9.99")),
				new Item("banana", 20, new BigDecimal("19.99")),
				new Item("orang", 10, new BigDecimal("29.99")),
				new Item("watermelon", 10, new BigDecimal("29.99")),
				new Item("papaya", 20, new BigDecimal("9.99")),
				new Item("apple", 10, new BigDecimal("9.99")),
				new Item("banana", 10, new BigDecimal("19.99")),
				new Item("apple", 20, new BigDecimal("9.99")));

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
		System.out.println(mapWithPrice);

		// Question 4 - How will you group by name & qty both
		Map<NameQtyKey, List<Item>> grouped = items.stream().collect(
				Collectors.groupingBy(item -> new NameQtyKey(item.getName(), item.getQuantity())));

		System.out.println(" =============== ");
		grouped.forEach((key, itemList) -> {
			System.out.println(key + " -> " + itemList.size() + " items");
			itemList.forEach(item -> System.out.println("  " + item));
		});

		System.out.println(mapWithPrice);

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
