package org.design.shoppingcard;

public interface TaxStrategy {
	double calculateTax(Item item);
}

class NoTaxStrategy implements TaxStrategy {
	@Override
	public double calculateTax(Item item) {
		return 0;
	}
}

class BasicTaxStrategy implements TaxStrategy {
	private static final double BASIC_TAX_RATE = 0.10;

	@Override
	public double calculateTax(Item item) {
		return item.getPrice() * BASIC_TAX_RATE;
	}
}

class ImportTaxStrategy implements TaxStrategy {
	private static final double IMPORT_TAX_RATE = 0.05;

	@Override
	public double calculateTax(Item item) {
		return item.getPrice() * IMPORT_TAX_RATE;
	}

}