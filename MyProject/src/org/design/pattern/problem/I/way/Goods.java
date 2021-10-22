package org.design.pattern.problem.I.way;

public abstract class Goods implements Item{

	// define attribute
	private String description;
	private int qty;
	private double price;
	private boolean imported;
	private Tax tax = new Tax();
	
	public Goods(String description,int qty,double price) {
		this.description =description;
		this.qty = qty;
		this.price = price;
	}
	
	protected abstract boolean isTaxes();
	protected abstract boolean isImported();
	
	public double getExtendedTax() {
		tax.calculate(isTaxes(),isImported(),price);
		return 0;
	}

	public double getExtendedTaxPrice() throws ItemException {
		if(tax == null) {
			throw new ItemException("Tax should be caulcualted first:");
		}
		
		return qty *(this.tax.getTotalUnitTax() + price);
	}

	public void setImported(boolean imported) {
		this.imported =imported;
	}

	public String getDescription() {
		return description;
	}

}
