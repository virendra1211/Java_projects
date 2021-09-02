package org.test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CollectionTest {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		
		list.add("abc");
		list.add("bca");list.add("abc");
		list.add("ecarr");list.add("hbc");
		list.add("fcaee");list.add("kbc");
		list.add("bca");list.add("abc");
		// I approach where i remove string which is start from "a"
		list.removeIf(new Predicate<String>() {
			
			public boolean test(String s) {
				return s.startsWith("a");
				//return s.length()>3;
			}
		});
		System.out.println(list);
		
		// II approach where i can remove or add
		List<String> ll = new ArrayList<String>();
		List<String> otherList = ll.stream().map(s ->s).collect(Collectors.toList());
		// .map(Studen::getName()
		// map method is intermediate operation and consumes single element 
		// forom input Stream and produces single element to output Stream.
		
	}
}
