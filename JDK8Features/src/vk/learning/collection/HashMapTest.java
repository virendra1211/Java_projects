package vk.learning.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

public class HashMapTest {

	static void otherWay() {
		System.out.println(10 + 20 + "Hello" + 10 + 20);

		HashMap<Person, String> map = new HashMap<>();
		Person p1 = new Person("John");
		Person p2 = new Person("John");

		map.put(p1, "Developer");

		System.out.println("$$ " + map.get(p1)); // Output: Developer
		System.out.println("$$ " + map.get(p2)); // Output: null, even though p1 and p2 have the
													// same data
		Integer a = 100;
		Integer b = 100;
		System.out.println(a == b); // true
		// integer caching between -128 to 127
		Integer c = 127;
		Integer d = 127;
		System.out.println(c == d); // false
	}

	public static void main(String[] args) {
		otherWay();
		Map<Key, String> cityMap = new HashMap<Key, String>();
		cityMap.put(new Key(1, "NY"), "New York City");
		cityMap.put(new Key(2, "ND"), "New Delhi");
		cityMap.put(new Key(3, "NW"), "Newark");
		Key key1 = new Key(4, "NP");
		cityMap.put(key1, "Newport");
		Key key2 = new Key(4, "NP");
		cityMap.put(key2, "Newport");
		cityMap.put(null, null); // here size incresed because null

		System.out.println("---- " + cityMap.get(key2)); // Output: Developer
		System.out.println("---- " + cityMap.get(key1)); // Output: Developer

		System.out.println("size before iteration " + cityMap.size());
		Iterator<Key> itr = cityMap.keySet().iterator();
		while (itr.hasNext()) {
			System.out.println(cityMap.get(itr.next()));
		}
		System.out.println("size after iteration " + cityMap.size());
	}
}

// This class' object is used as key
// in the HashMap
class Key {
	int index;
	String Name;

	Key(int index, String Name) {
		this.index = index;
		this.Name = Name;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Key other = (Key) obj;
		return Objects.equals(Name.trim(), other.Name.trim()) && index == other.index;
	}

}

class Person {
	String name;

	Person(String name) {
		this.name = name;
	}
}
