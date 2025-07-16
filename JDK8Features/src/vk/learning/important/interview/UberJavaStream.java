package vk.learning.important.interview;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class UberJavaStream {

	public static void main(String[] args) {
		List<Employees1> employees = Arrays.asList(new Employees1(101, "HR", 50000),
				new Employees1(102, "IT", 75000), new Employees1(103, "Sales", 62000),
				new Employees1(104, "IT", 90000), new Employees1(105, "HR", 55000),
				new Employees1(106, "Finance", 80000), new Employees1(107, "Sales", 62000),
				new Employees1(108, "IT", 85000));

		/*
		 * List of employees - Group By salary - Max/min salary in each dept - Sum of
		 * salaries in each dept - print all employees belonging to a dept - count num
		 * of employes belonging to a group
		 */
		Map<Long, List<Employees1>> groupOfList = employees.stream()
				.collect(Collectors.groupingBy(Employees1::salary));
		System.out.println(groupOfList);
		// sum of salary for each department
		Map<String, Long> groupOfList1 = employees.stream().collect(Collectors
				.groupingBy(Employees1::department, Collectors.summingLong(Employees1::salary)));
		System.out.println("sum of salary " + groupOfList1);
		// count num of employes belonging to a group

		Map<String, Long> countEmployeeByGroup = employees.stream()
				.collect(Collectors.groupingBy(Employees1::department, Collectors.counting()));
		System.out.println(countEmployeeByGroup);

		String sentence = "Stream API makes Java code more elegant and powerful";
		// Given a sentence, find largest word using streams?
		Optional<String> result1 = Arrays.asList(sentence.split(" ")).stream()
				.sorted(Comparator.comparing(String::length).reversed()).findFirst();

		System.out.println(result1.get());
		// min and max for each department
		Map<String, Map<String, Long>> ans = employees.stream().collect(Collectors.groupingBy(
				Employees1::department, Collectors.collectingAndThen(Collectors.toList(), list1 -> {
					Optional<Employees1> max = list1.stream()
							.max(Comparator.comparingLong(Employees1::salary));
					Optional<Employees1> min = list1.stream()
							.min(Comparator.comparingLong(Employees1::salary));
					return Map.of("max", max.get().salary(), "min", min.get().salary());
				})));

		System.out.println("min and max " + ans);

		Map<String, Map<String, Double>> ans1 = employees.stream().collect(Collectors.groupingBy(
				Employees1::department,
				Collectors.teeing(Collectors.maxBy(Comparator.comparing(Employees1::salary)),
						Collectors.minBy(Comparator.comparing(Employees1::salary)),
						(max, min) -> Map.of("max", max.map(e -> (double) e.salary()).orElse(0.0),
								"min", min.map(e -> (double) e.salary()).orElse(0.0)))));

		System.out.println("min and max " + ans1);
	}

}

record Employees1(Integer id, String department, long salary) {

}
