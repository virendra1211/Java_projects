package org.design.shoppingcard;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
	private List<CartItem> items = new ArrayList<>();

	public void addItem(CartItem item) {
		items.add(item);
	}

	public void printReceipt() {
		double total = 0;
		double totalTax = 0;

		for (CartItem item : items) {
			item.printReceipt();
			total += item.getTotalPrice();
			totalTax += item.getTotalPrice() - item.getItem().getPrice();
		}

		System.out.printf("Sales Taxes: %.2f%n", totalTax);
		System.out.printf("Total: %.2f%n", total);
	}
}
