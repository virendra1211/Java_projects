package vk.learning.important.interview;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CountDuplicateCharacterJava8 {

	private static Map<Character, Long> map;

	public static void main(String[] args) {

		// given input string
		String input = "JavaJavaEE";

		// convert string into stream
		Map<Character, Long> result = input.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(c -> c, Collectors.counting()));
		result.forEach((k, v) -> {
			if (v > 1) {
				System.out.println(k + " : " + v);
			}
		});

		Map<Character, Long> result1 = input.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(c -> c, Collectors.counting())).entrySet().stream()
				.filter(p -> p.getValue() > 1 && p.getValue() < 3).collect(Collectors.toMap(
						Map.Entry::getKey, Map.Entry::getValue, (o, n) -> o, LinkedHashMap::new));

		result1.forEach((p, g) -> {
			System.out.println(p + " = " + g);
		});
	}

}

class MyObj {
	public MyObj(int count, int index) {
		super();
		this.count = count;
		this.index = index;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	private int count;
	private int index;

}
