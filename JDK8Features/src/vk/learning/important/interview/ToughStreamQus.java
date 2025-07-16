package vk.learning.important.interview;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ToughStreamQus {
	static List<Order> orders = Arrays.asList(
			new Order(
					Arrays.asList(new Product("Laptop", "Electronics", 1, true),
							new Product("Mouse", "Electronics", 3, true)),
					1200, LocalDateTime.now().minusHours(3)), // included

			new Order(
					Arrays.asList(new Product("Socks", "Clothing", 3, true),
							new Product("Belt", "Clothing", 1, true)),
					450, LocalDateTime.now().minusHours(1)), // excluded (value <= 500)

			new Order(
					Arrays.asList(new Product("Notebook", "Stationery", 5, true),
							new Product("Pen", "Stationery", 10, true)),
					550, LocalDateTime.now().minusHours(5)), // included

			new Order(Arrays.asList(new Product("Blender", "Home & Kitchen", 1, false), // out of
					new Product("Mixer", "Home & Kitchen", 1, true)), 650,
					LocalDateTime.now().minusHours(30)), // excluded (too old)

			new Order(
					Arrays.asList(new Product("Charger", "Electronics", 1, true),
							new Product("Power Bank", "Electronics", 1, true)),
					800, LocalDateTime.now().minusHours(4)), // included

			new Order(Arrays.asList(new Product("Cap", "Clothing", 2, true),
					new Product("Gloves", "Clothing", 1, false) // out of stock
			), 300, LocalDateTime.now().minusHours(2))); // excluded (value <= 500)

	public static void main(String[] args) {

		// 1. total value > 500
		// 2. exclude product out of stock
		// 3 . producer sorted based on the quantity
		Map<String, Integer> result = orders.stream()
				.filter(order -> order.getOrderTime().isAfter(LocalDateTime.now().minusHours(24)))
				.filter(order -> order.getTotalValue() > 500)
				.flatMap(order -> order.getProducts().stream())
				.filter(product -> product.isInStock())
				.collect(Collectors.groupingBy(Product::getCategory,
						Collectors.summingInt(Product::getQuantity)))
				.entrySet().stream()
				.sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (o, n) -> o,
						LinkedHashMap::new));

		System.out.println(result);
		// 2nd questions

	}
}

class Order {
	private List<Product> products;
	private int totalValue;
	private LocalDateTime orderTime;

	public Order(List<Product> products, int totalValue, LocalDateTime orderTime) {
		this.products = products;
		this.totalValue = totalValue;
		this.orderTime = orderTime;
	}

	// Getters
	public List<Product> getProducts() {
		return products;
	}

	public int getTotalValue() {
		return totalValue;
	}

	public LocalDateTime getOrderTime() {
		return orderTime;
	}

	@Override
	public String toString() {
		return "Order{" + "products=" + products + ", totalValue=" + totalValue + ", orderTime="
				+ orderTime + '}';
	}
}

class Product {
	private String name;
	private String category;
	private int quantity;
	private boolean inStock;

	public Product(String name, String category, int quantity, boolean inStock) {
		this.name = name;
		this.category = category;
		this.quantity = quantity;
		this.inStock = inStock;
	}

	// Getters
	public String getName() {
		return name;
	}

	public String getCategory() {
		return category;
	}

	public int getQuantity() {
		return quantity;
	}

	public boolean isInStock() {
		return inStock;
	}

	@Override
	public String toString() {
		return "Product{" + "name='" + name + '\'' + ", category='" + category + '\''
				+ ", quantity=" + quantity + ", inStock=" + inStock + '}';
	}
}
