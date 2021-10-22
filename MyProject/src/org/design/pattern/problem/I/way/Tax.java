package org.design.pattern.problem.I.way;

public class Tax {

	public static final double SALES_TAX = 0.10; //10%
	public static final double IMPORTED_TAX = 0.05; // 5%
	private double salesTax = 0.0;
	private double importedTax = 0.0;

	public void calculate(boolean isTaxable, boolean isImported, double price) {
		if(isTaxable) {
			salesTax = price * SALES_TAX;
		}
		if(isImported) {
			importedTax = price * IMPORTED_TAX;
		}
	}
	
	public double getTotalUnitTax() {
		return this.salesTax + this.importedTax;
	}

}
