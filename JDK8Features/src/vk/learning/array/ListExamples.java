package vk.learning.array;

import java.util.ArrayList;
import java.util.List;

public class ListExamples {
	public static void main(String[] args) {
		verifyOfMethod();
		List<Integer> ll = new ArrayList<>();
		ll.add(null);
		System.out.println(ll.size());
	}

	private static void verifyOfMethod() {
		// List<String> list2 = List.of("1", "2", null);
		try {
			List<Integer> list2 = List.of(1, 2, null);
			System.out.println(list2.size());
			list2.forEach(p -> System.out.println(p));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
