package vk.java8.stream.problems;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import vk.learning.important.interview.Employee;

public class PrintNoOfOccurence {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 2, 0, 4, 3, 0, 0, 1 };

		Map<Integer, Long> frequencyMap = IntStream.of(arr).boxed()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		System.out.println(frequencyMap);
		Map<Integer, Integer> map = new HashMap<>();
		for (Integer a : arr) {
			if (map.putIfAbsent(a, 1) != null) {
				map.put(a, map.get(a) + 1);
			}
		}
		System.out.println(map);

		Integer[] empIds = { 1, 2, 3 };
		PrintNoOfOccurence obj = new PrintNoOfOccurence();
		List<Employee> employees = Stream.of(empIds).map(obj::findById)
				.collect(Collectors.toList());
		employees.forEach(System.out::println);
	}

	private Employee findById(Integer i) {
		return new Employee(i, "a");
	}

}
