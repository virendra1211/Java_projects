package org.design.pattern;

public class Customer {

	public static void main(String[] args) {
		Item[] items = new Item[] {
			new Computer(20000,"com123"),
			new Printer(1000,6,"HP2XR")	,
			new Printer(975,5,"LNV 222")
		};
		
		int totalCost=calculatePrice(items);
		System.out.println("Total cost of purchasing is "+totalCost);
	}

	private static int calculatePrice(Item[] items) {
		ShoppingCartVisitor  shoppingCartVisitor = new ShoppinCartVisitorImpl();
		int sum=0;
		for(Item item:items) {
			sum = sum + item.accept(shoppingCartVisitor);
		}
		return sum;
	}

}
