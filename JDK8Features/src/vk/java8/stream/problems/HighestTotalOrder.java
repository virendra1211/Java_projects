package vk.java8.stream.problems;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HighestTotalOrder {

    public static void main(String[] args) {
	List<Order> orders = Arrays.asList(new Order("Alice", 120.0), new Order("Bob", 300.0), new Order("Alice", 80.0),
		new Order("Charlie", 150.0), new Order("David", 220.0), new Order("Eve", 400.0),
		new Order("Frank", 250.0), new Order("Eve", 100.0), new Order("Charlie", 200.0));

	List<Map.Entry<String, Double>> top5Customers = orders.stream()
		.collect(Collectors.groupingBy(Order::getCustomerName, Collectors.summingDouble(Order::getAmount)))
		.entrySet().stream().sorted(Map.Entry.<String, Double>comparingByValue().reversed()).limit(5)
		.collect(Collectors.toList());

	top5Customers.forEach(
		entry -> System.out.println("customer " + entry.getKey() + " Total spent " + entry.getValue()));
    }

}

class Order {
    String customerName;
    double amount;

    public Order(String customerName, double amount) {
	this.customerName = customerName;
	this.amount = amount;
    }

    public String getCustomerName() {
	return customerName;
    }

    public double getAmount() {
	return amount;
    }
}