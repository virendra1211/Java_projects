package org.design.shoppingcard;

public class CartItem {
	private Item item;
	private TaxStrategy taxStrategy;

	public CartItem(Item item, TaxStrategy taxStrategy) {
		this.item = item;
		this.taxStrategy = taxStrategy;
	}

	public double getTotalPrice() {
		return item.getPrice() + taxStrategy.calculateTax(item);
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public TaxStrategy getTaxStrategy() {
		return taxStrategy;
	}

	public void setTaxStrategy(TaxStrategy taxStrategy) {
		this.taxStrategy = taxStrategy;
	}

	public void printReceipt() {
		System.out.printf("%s: %.2f%n", item.getName(), getTotalPrice());
	}

}
