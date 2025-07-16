package vk.learning.important.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// https://app.eraser.io/workspace/peWcG5PxQDfK1iEy4rYt
public class ToughStream_1 {
	public static void main(String[] args) {
		// sample product stock
		// Sample product stock levels (productId -> available stock)
		Map<String, Integer> productStock = new HashMap<>();
		productStock.put("P001", 100); // Product P001 has 100 items in stock
		productStock.put("P002", 50); // Product P002 has 50 items in stock
		productStock.put("P003", 200); // Product P003 has 200 items in stock

		// Sample orders
		List<Order1> orders = new ArrayList<>();
		orders.add(new Order1("O001",
				Arrays.asList(new Product1("P001", 30), new Product1("P002", 60))));
		orders.add(new Order1("O002",
				Arrays.asList(new Product1("P003", 50), new Product1("P002", 40))));
		orders.add(new Order1("O003",
				Arrays.asList(new Product1("P001", 120), new Product1("P003", 30))));

		List<String> probemeticOrder = orders.stream()
				.filter(order -> order.getProducts().stream().anyMatch(product -> {
					int availableStock = productStock.getOrDefault(product.getProductId(), 0);
					return product.getQuantity() > availableStock;
				})).map(Order1::getOrderId).collect(Collectors.toList());
		System.out.println(probemeticOrder);
	}
}

class Product1 {
	private String productId;
	private int quantity;

	public Product1(String productId, int quantity) {
		this.productId = productId;
		this.quantity = quantity;
	}

	public String getProductId() {
		return productId;
	}

	public int getQuantity() {
		return quantity;
	}
}

class Order1 {
	private String orderId;
	private List<Product1> products;

	public Order1(String orderId, List<Product1> products) {
		this.orderId = orderId;
		this.products = products;
	}

	public String getOrderId() {
		return orderId;
	}

	public List<Product1> getProducts() {
		return products;
	}
}
