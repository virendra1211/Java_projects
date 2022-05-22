package org.jdk8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HashMapByValueSort {
	public static void main(String[] args) {
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("b", 200);
		map.put("a", 500);
		map.put("e", 220);
		map.put("c", 540);
		map.put("h", 300);
		map.put("g", 350);

		List<Map.Entry<String, Integer>> sortedList = new ArrayList<Map.Entry<String,Integer>>(map.entrySet());

		/** I way **/
		Map<String, Integer> sortedMapWithValue = map.entrySet().stream()
				.sorted((p1, p2) -> p1.getValue().compareTo(p2.getValue()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(o,n) ->o,LinkedHashMap::new));
		System.out.println("sortedMapWithValue " + sortedMapWithValue);
		
		/** II way **/
		Collections.sort(sortedList,(p1,p2) -> p1.getValue().compareTo(p2.getValue()));
		
		sortedList.forEach(System.out::println);
		System.out.println(map);
		System.out.println(" ========================== ");

		/** III way **/
		Map<String, Integer> sortedMap = map.entrySet().stream()
				.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors.toMap(
						Map.Entry::getKey, Map.Entry::getValue, (oldvalue, newvalue) -> oldvalue, LinkedHashMap::new));
		 	
		  
		  map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.
		  reverseOrder())).collect(Collectors.toMap(Map.Entry::getKey, 
		  Map.Entry::getValue, (o,n) ->  o,LinkedHashMap::new));
		  //System.out.println(sortedMap);

	
	}
}
