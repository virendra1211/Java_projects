package org.test;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
/*
	Here two way declare to remove values from the arraylist but i would like to add one point here
	If we want to add or change order " then we should use "ListIterator" instead of iterator
 */
public class ArrayListValueRemoveIterator {
	public static void main(String[] args) {
		List<String> list =new ArrayList<String>();
		list.add("a");list.add("b");list.add("c");
		list.add("d");list.add("e");list.add("f");

		List<String> list1 = new ArrayList<String>();
		list1.addAll(list);
		
		// I approach
		int count =0;
		for(String s: list1) {
			if(count == 2) {
				list.remove(count-1);
			}
			count++;
		}
		
		System.out.println(list);
		
		// II approach
		
		//Iterator i = list.iterator();
		ListIterator i = list.listIterator();
	      String str = "";
	      while (i.hasNext()) {
	         str = (String) i.next();
	         if (str.equals("e")) {
	            i.remove();
	           i.add("j");
	            System.out.println("\nThe element Orange is removed");
	            break;
	         }
	      }
			System.out.println(list);
	}
}
