package org.design.pattern.problem.I.way;

public class CD extends Goods{
	private boolean isTaxes = true;
	private boolean isImported = false;
	
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

	public CD(String description,int qry,double price) {
		super(description,qry,price);
	}
	
}
