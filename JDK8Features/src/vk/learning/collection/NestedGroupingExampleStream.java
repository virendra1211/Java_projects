package vk.learning.collection;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class NestedGroupingExampleStream {
	public static void main(String[] args) {
		// Sample customers
		Customer customer1 = new Customer(1, "Alice");
		Customer customer2 = new Customer(2, "Bob");

		// Sample orders
		List<Order> orders = Arrays.asList(new Order(101, customer1, Status.NEW),
				new Order(102, customer1, Status.COMPLETED), new Order(103, customer1, Status.NEW),
				new Order(104, customer2, Status.PROCESSING),
				new Order(105, customer2, Status.PROCESSING),
				new Order(106, customer2, Status.COMPLETED));

		// Group by Customer -> then by Status -> List<Order>
		Map<Customer, Map<Status, List<Order>>> groupedOrders = orders.stream().collect(
				Collectors.groupingBy(Order::getCustomer, Collectors.groupingBy(Order::getStatus)));

		// Print the result
		groupedOrders.forEach((customer, statusMap) -> {
			System.out.println("Customer: " + customer.getName());
			statusMap.forEach((status, orderList) -> {
				System.out.println("  Status: " + status);
				orderList.forEach(order -> System.out.println("    Order ID: " + order.getId()));
			});
		});
	}
}

class Customer {
	private int id;
	private String name;

	public Customer(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	// Required for using Customer as Map key
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Customer))
			return false;
		Customer customer = (Customer) o;
		return id == customer.id && Objects.equals(name, customer.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	@Override
	public String toString() {
		return name;
	}
}

enum Status {
	NEW, PROCESSING, COMPLETED
}

class Order {
	private int id;
	private Customer customer;
	private Status status;

	public Order(int id, Customer customer, Status status) {
		this.id = id;
		this.customer = customer;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public Status getStatus() {
		return status;
	}
}

sealed interface A permits X, Common {
}

sealed interface B permits Y, Common {
}

// A class trying to implement both
final class Common implements A, B {
}

final class Invalid implements A, B {
}

final class X implements A {

}

final class Y implements B {

}