package org.design.pattern.problem.II.way;

import org.design.pattern.problem.I.way.Item;
import org.design.pattern.problem.I.way.ItemException;

public abstract class ItemFactory {
	public abstract Item getItem(int itemType,String description,int qty,double price) throws ItemException;

}
