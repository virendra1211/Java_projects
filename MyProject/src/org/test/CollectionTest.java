package org.test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class CollectionTest {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		
		list.add("abc");
		list.add("bca");list.add("abc");
		list.add("ecarr");list.add("hbc");
		list.add("fcaee");list.add("kbc");
		list.add("bca");list.add("abc");
		
		list.removeIf(new Predicate<String>() {
			@Override
			public boolean test(String s) {
				return s.startsWith("a");
				//return s.length()>3;
			}
		});
		System.out.println(list);
		
	}
}
