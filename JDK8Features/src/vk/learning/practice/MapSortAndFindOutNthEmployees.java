package vk.learning.practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapSortAndFindOutNthEmployees {
	public static void main(String[] args) {
		mapMethod(10);
		List<Integer> list = List.of(5, 4, 3, 2, 1);
		// list.stream().skip(2).limit(1).forEach(System.out::println);
		// skip 3,2,1 limit 3
	}

	private static void mapMethod(int nth) {
		Map<String, Integer> employeeMap = new HashMap<String, Integer>();
		employeeMap.put("Virendra", 2000);
		employeeMap.put("Venkat", 3000);
		employeeMap.put("Praveen", 4000);
		employeeMap.put("Dinesh", 5000);
		employeeMap.put("Ravi", 1000);
		employeeMap.put("Ramu", 4000);
		employeeMap.put("Sourab", 5000);
		employeeMap.put("Gourav", 3000);
		employeeMap.put("Raju", 2000);
		employeeMap.put("Ramya", 1000);
		// Ex:- input can be passed as 2nd highest and fetch the employee

		List<Integer> salaryList = new ArrayList<>(employeeMap.values());
		/*
		 * TreeSet<Integer> ts = new TreeSet<Integer>((a, b) -> b.compareTo(a));
		 * ts.addAll(employeeMap.values());
		 */

		List<Integer> descSalaryList = salaryList.stream().distinct()
				.sorted(Comparator.reverseOrder()).collect(Collectors.toList());

		if (nth - 1 >= descSalaryList.size()) {
			System.out.println("There are less than " + nth + " distinct slaaries");
			return;
		}

		int tagetSalary = descSalaryList.get(nth - 1);

		List<String> employees = employeeMap.entrySet().stream()
				.filter(entry -> entry.getValue() == tagetSalary).map(Map.Entry::getKey).sorted()
				.collect(Collectors.toList());

		System.out.println("Employee with " + nth + " highest salary " + tagetSalary);
		employees.forEach(System.out::println);
	}
}
