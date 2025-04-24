package vk.java8.features;

import java.util.List;

public class ReduceExample {
    public static void main(String[] args) {
	List<String> list = List.of("apple", "banana", "cherry");
	List<Integer> numbers = List.of(1, 2, 3, 4, 5);

	Integer sum = numbers.stream().reduce(0, (a, b) -> a + b);
	System.out.println(sum);

	String result = list.stream().reduce("", (a, b) -> a + b.charAt(0));
	System.out.println(result);

    }
}
