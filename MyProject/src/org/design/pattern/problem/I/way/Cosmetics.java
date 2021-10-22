package org.design.pattern.problem.I.way;

public class Cosmetics extends Goods{
	private boolean isTaxes = true;
	private boolean isImported = true;
	
	public boolean isTaxes() {
		return isTaxes;
	}

	public void setTaxes(boolean isTaxes) {
		this.isTaxes = isTaxes;
	}

	public boolean isImported() {
		return isImported;
	}

	public void setImported(boolean isImported) {
		this.isImported = isImported;
	}

	public Cosmetics(String description,int qry,double price) {
		super(description,qry,price);
	}
	
}
