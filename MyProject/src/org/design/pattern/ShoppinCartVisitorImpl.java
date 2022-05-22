package org.design.pattern;

public class ShoppinCartVisitorImpl implements ShoppingCartVisitor{

	@Override
	public int visit(Computer computer) {
		int cost = 0;
		if(computer.getCost() > 15000) {
			cost = computer.getCost() - 50;
		}else {
			cost = computer.getCost();
		}
		System.out.println("computer serial Numer "+computer.getSerialNumber()+", cost "+cost);
		return cost;
	}

	@Override
	public int visit(Printer printer) {
		int cost= printer.getPriceCartridge() * printer.getNoOfCartridge();
		System.out.println("Printer "+printer.getNodeNumber() +", cost 	"+cost);
		return cost;
	}

}
