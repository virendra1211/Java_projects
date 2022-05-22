package org.design.pattern;

interface ShoppingCartVisitor {
	int visit(Computer computer);
	int visit(Printer printer);
}

interface Item{
	public int accept(ShoppingCartVisitor visitor);
}

class Computer implements Item{

	private int cost;
	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	private String serialNumber;
	
	public Computer(int cost, String serialNumber) {
		super();
		this.cost = cost;
		this.serialNumber = serialNumber;
	}

	@Override
	public int accept(ShoppingCartVisitor visitor) {
		
		return visitor.visit(this);
	}
	
}