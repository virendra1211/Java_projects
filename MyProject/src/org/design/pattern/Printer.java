package org.design.pattern;

public class Printer implements Item{
	int priceCartridge; int noOfCartridge;String nodeNumber;
	
	public int getPriceCartridge() {
		return priceCartridge;
	}

	public int getNoOfCartridge() {
		return noOfCartridge;
	}

	public String getNodeNumber() {
		return nodeNumber;
	}

	public Printer(int priceCartridge, int noOfCartridge,String nodeNumber) {
		this.priceCartridge = priceCartridge;
		this.noOfCartridge =noOfCartridge;
		this.nodeNumber = nodeNumber;
	}
	
	@Override
	public int accept(ShoppingCartVisitor visitor) {
		return visitor.visit(this);
	}

	
}