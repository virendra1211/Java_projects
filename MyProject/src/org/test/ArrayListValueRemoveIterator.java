package org.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
		
		Iterator i = list.iterator();
	      String str = "";
	      while (i.hasNext()) {
	         str = (String) i.next();
	         if (str.equals("e")) {
	            i.remove();
	            System.out.println("\nThe element Orange is removed");
	            break;
	         }
	      }
		
	}
}
