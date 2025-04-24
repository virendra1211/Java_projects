package org.collections.examples;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ImmutableMap {
    public static void main(String[] args) {
	Map<String, String> map = new HashMap<String, String>(); /*
								  * { public String put(String key, String value) {
								  * return super.putIfAbsent(key, value); } };
								  */
	map.put("a", "a1");
	map.put("b", "b1");
	map.put("c", "c1");

	Collections.unmodifiableMap(map);
	map.put("aq", "aaa");
	map.forEach((a, b) -> System.out.println(a + " - " + b));
    }

    /*
     * // Function to create ImmutableMap from Map public static <K, T> void
     * iMap(Map<K, T> map) { // Create ImmutableMap from Map using copyOf()
     * ImmutableMap immutableMap = ImmutableMap.copy(map);
     * 
     * // Print the ImmutableMap System.out.println(immutableMap); }
     * 
     * private static ImmutableMap copy(Map<K, T> map) { return null; }
     */
}
