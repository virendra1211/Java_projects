package org.design.shoppingcard;

public class Item {
	private String name;
	private double price;
	private boolean imported;
	private boolean taxFree;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isImported() {
		return imported;
	}

	public void setImported(boolean imported) {
		this.imported = imported;
	}

	public boolean isTaxFree() {
		return taxFree;
	}

	public void setTaxFree(boolean taxFree) {
		this.taxFree = taxFree;
	}

	public Item(String name, double price, boolean imported, boolean taxFree) {
		super();
		this.name = name;
		this.price = price;
		this.imported = imported;
		this.taxFree = taxFree;
	}

}
