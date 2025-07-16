package org.design.shoppingcard;

import java.util.List;

public class Main {
	public static void main(String[] args) {
		Item book = new Item("Book", 12.49, false, false);
		Item musicCD = new Item("Music CD", 14.99, false, false);
		Item importedPerfume = new Item("Imported Perfume", 47.50, true, false);

		CartItem bookItem = new CartItem(book, new NoTaxStrategy());
		CartItem musicItem = new CartItem(musicCD, new BasicTaxStrategy());

		TaxStrategy importAndBasic = new CompositeTaxStrategy(
				List.of(new BasicTaxStrategy(), new ImportTaxStrategy()));
		CartItem perfumeItem = new CartItem(importedPerfume, importAndBasic);

		ShoppingCart cart = new ShoppingCart();
		cart.addItem(bookItem);
		cart.addItem(musicItem);
		cart.addItem(perfumeItem);

		cart.printReceipt();
	}
}
