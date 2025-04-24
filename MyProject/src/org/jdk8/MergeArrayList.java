package org.jdk8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MergeArrayList {
    @SuppressWarnings("rawtypes")
    public static void main(String[] args) {

	// ************* I Merge Two List
	List<String> listOne = Arrays.asList("Apple", "Orange");
	List<String> listTwo = Arrays.asList("Banana", "Grape");

	List<String> newList = Stream.concat(listOne.stream(), listTwo.stream()).collect(Collectors.toList());
	System.out.println(newList);

	// ************* II Merge Two List of list
	List<String> innerList1 = Arrays.asList("Spring", "Summer");
	List<String> innerList2 = Arrays.asList("Fall", "Winter");

	List<List<String>> outerList1 = new ArrayList<>();
	outerList1.add(innerList1);
	List<List<String>> outerList2 = new ArrayList<>();
	outerList2.add(innerList2);

	List<String> result = Stream.of(outerList1, outerList2).flatMap(Collection::stream).flatMap(Collection::stream)
		.collect(Collectors.toList());

	System.out.println(result);

	ConcurrentHashMap<String, String> clist = new ConcurrentHashMap<String, String>();
	// clist.put(null, null); not allowed
	clist.put("null", "null");
	clist.put("null", "null2");
	// clist.put("null", null); not allowed as null key and value not accepted
	System.out.println(clist);

    }
}
