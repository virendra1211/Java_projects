package org.design.pattern.problem.II.way;

import org.design.pattern.problem.I.way.Book;
import org.design.pattern.problem.I.way.CD;
import org.design.pattern.problem.I.way.Cosmetics;
import org.design.pattern.problem.I.way.Item;
import org.design.pattern.problem.I.way.ItemException;

public  class GoodsFactory extends ItemFactory{
	
	public Item getItem(int itemType,String description,int qty,double price) throws ItemException{
		Item item = null;
		if(itemType == Item.TYPE_BOOK) {
			item = new Book(description,qty,price);
		}else if(itemType == Item.TYPE_CD) {
			item = new CD(description,qty,price);
		}else if(itemType == Item.TYPE_COSMETIC) {
			item = new Cosmetics(description,qty,price);
		}else {
			throw new ItemException("Invalid Item Type "+itemType);
		}
		return item;
	}
}
