package org.collections.examples;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ImmutableMap {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>(); /*
																	 * { public String put(String
																	 * key, String value) { return
																	 * super.putIfAbsent(key,
																	 * value); } };
																	 */
		map.put("a", "a1");
		map.put("b", "b1");
		map.put("c", "c1");

		Collections.unmodifiableMap(map);
		map.put("aq", "aaa");
		map.forEach((a, b) -> System.out.println(a + " - " + b));
		checkHashAndEquals();
	}

	private static void checkHashAndEquals() {
		Map<POJO, String> objectMap = new HashMap<>();
		objectMap.put(new POJO(1, "abc"), "abc");
		objectMap.put(new POJO(1, "abc"), "abc");
		objectMap.put(new POJO(1, "abc"), "abc");
		System.out.println("size");
		System.out.println(objectMap.size());
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

class POJO {
	private Integer id;

	public POJO(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		POJO other = (POJO) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}

}