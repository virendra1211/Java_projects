package org.design.pattern.problem.I.way;

public class MainPrice {
	public static void main(String[] args) throws ItemException {
		Goods good = new CD("CD", 10, 50);
		System.out.println(good.getExtendedTax());
		System.out.println(good.getExtendedTaxPrice());
	}
}
