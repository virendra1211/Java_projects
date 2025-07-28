package org.ask.interview.coding;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 
 * @author Virendra khade How to create Immutable class in Java 1. Declare the
 *         class is final so can't be extended 2. make all field private so that
 *         direct access is not allowed 3. don't provide setter methods for
 *         variable 4. Make all mutable fields Final so that it's value can be
 *         assigned only once. 5. Initialize all the field via constructor
 *         performing deep copy 6. perform cloning of object in the getter
 *         methods to return a copy rather than returning the actual object
 */
public class ImmutableClass {
	public static void main(String[] args) {
		checkCustomImmutableClass();
		/*
		 * List<String> alphaList = Arrays.asList("a", "b", "c", "d"); List<String>
		 * aList = Collections.unmodifiableList(alphaList); alphaList.add("e");
		 * System.out.println("alphaList- " + alphaList); aList.add("f");
		 */
		/*
		 * List<String> alphaList = List.of("a", "b", "c", "d");
		 * System.out.println("alphaList- " + alphaList); // raises error
		 * alphaList.add("e");
		 */

	}

	private static void checkCustomImmutableClass() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("a1", "abc");
		MyFinalClass obj = new MyFinalClass(1, "name", map, new Date());
		obj.getTestMap().put("a1", "abc1");
		System.out.println(obj.getTestMap().get("a1"));
	}

}

final class MyFinalClass {

	private final Integer id;
	private final String name;
	private final HashMap<String, String> testMap;
	private final Date birthDate;

	/**
	 * Accessor function for mutable objects
	 */
	public HashMap<String, String> getTestMap() {
		// return testMap;
		return (HashMap<String, String>) testMap.clone();
	}

	/**
	 * Constructor performing Deep Copy
	 * 
	 * @param i
	 * @param n
	 * @param map
	 */

	public MyFinalClass(int i, String n, Map<String, String> map, Date birthDate) {
		System.out.println("Performing Deep Copy for Object initialization");
		this.id = i;
		this.name = n;
		HashMap<String, String> tempMap = new HashMap<String, String>();
		String key;
		Iterator<String> it = map.keySet().iterator();
		while (it.hasNext()) {
			key = it.next();
			tempMap.put(key, map.get(key));
		}
		this.testMap = tempMap;
		this.birthDate = birthDate;
	}

	// RIGHT
	public Date getBirthDate() {
		return new Date(birthDate.getTime()); // Defensive copy
	}
}
