package vk.immutable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		for (int i = 0; i < 5; i++) {
			list.remove(5);
			System.out.println("Internal size " + list.size());
		}
		System.out.println("after " + list.size());

		final int x;
		x = 10;
		System.out.println(x + " " + x);

		String str = " java programming";
		String result1 = str.substring(5, 15).replace(" ", "");
		System.out.println(result1);
		Integer i = 0;
		Integer j = i;
		j = i++ + j;
		System.out.println(i + " - " + j);
		System.out.println(i + " - " + j);
		Map<String, String> concurrentHashMap = new ConcurrentHashMap<>();
		for (int p = 0; p < 33; p++) {
			concurrentHashMap.put("a" + p, "ab" + p);

		}

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		List<Integer> result = numbers.stream().filter(p -> p % 2 == 0).map(p -> p * p)
				.collect(Collectors.toList());

		System.out.println(result);

		List<Address> addressList = new ArrayList<>();
		addressList.add(new Address("New York", "5th Avenue"));
		addressList.add(new Address("Los Angeles", "Sunset Blvd"));

		Employee emp = new Employee("Alice", 101, addressList);
		System.out.println("Original Employee: " + emp);

		// Try modifying the original list after Employee is created
		addressList.add(new Address("Chicago", "Michigan Ave"));
		System.out.println("After modification attempts: " + emp);
		// Try modifying the returned list from getter
		List<Address> retrievedAddresses = emp.getAddresses();

		try {
			retrievedAddresses.add(new Address("Houston", "Main St"));
		} catch (UnsupportedOperationException e) {
			System.out.println("Modification attempt blocked: " + e);
		}

		System.out.println("After modification attempts: " + emp);
		System.out.println("**************");
		C c = new C();

	}
}

class A {
	public A() {
		System.out.println("Class A Constructor");
	}
}

class B extends A {
	public B() {
		System.out.println("Class B Constructor");
	}
}

class C extends B {
	public C() {
		System.out.println("Class C Constructor");
	}
}
