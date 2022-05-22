package org.jdk8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

class Person {
	int id;
	String name;

	public Person(int id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}

	/*
	 * @Override public int hashCode() { return Objects.hash(address, id, name); }
	 * 
	 */	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(address, other.address) && id == other.id && Objects.equals(name, other.name);
	}

	String address;
}

public class StreamTest {

	static List<Integer> myList = new ArrayList<>();

	public static void main(String[] args) {
		List<Person> list = new ArrayList<>();
		list.add(new Person(3, "abc", "pune"));
		list.add(new Person(5, "pqr", "pune"));
		list.add(new Person(2, "xyz", "pune"));
		list.add(new Person(1, "mno", "pune"));
		System.out.println(list.contains(new Person(3, "abc", "pune")));
		// above code return true if we have override equals and hash code method
		Map<String, String> map = new HashMap<String, String>();
		map.put("key1", "val1");
		map.put(new String("key1"), new String("val2"));
		map.put("key3", "val3");

		System.out.println(map.size()); // 2 size
		System.out.println(map.get("key1")); // return val2

		for (int i = 0; i < 5000000; i++)
			myList.add(i);

		int result = 0;
		long loopStartTime = System.currentTimeMillis();
		for (int i : myList) {
			if (i % 2 == 0)
				result += i;
		}

		long loopEndTime = System.currentTimeMillis();

		System.out.println(result);

		System.out.println("Loop total Time = " + (loopEndTime - loopStartTime));

		long streamStartTime = System.currentTimeMillis();

		System.out.println(myList.stream().filter(value -> value % 2 == 0).mapToInt(Integer::intValue).sum());

		long streamEndTime = System.currentTimeMillis();
		System.out.println("Stream total Time = " + (streamEndTime - streamStartTime));

		long parallelStreamStartTime = System.currentTimeMillis();
		System.out.println(myList.parallelStream().filter(value -> value % 2 == 0).mapToInt(Integer::intValue).sum());

		long parallelStreamEndTime = System.currentTimeMillis();

		System.out.println("Parallel Stream total Time = " + (parallelStreamEndTime - parallelStreamStartTime));
//////////////////////
		List<Integer> number = Arrays.asList(2, 3, 4, 5);
		// demonstration of reduce method
		int even = number.stream().filter(x -> x % 2 == 0).reduce(0, (ans, i) -> ans + i);
		System.out.println(even);

	}
}