package vk.java8.stream.problems;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Collectors_teeing {
	public static void main(String[] args) {
		List<Employee> employees = Arrays.asList(new Employee("Amit", 60000),
				new Employee("Neha", 75000), new Employee("Ravi", 50000),
				new Employee("Priya", 80000));

		// Teeing: sum and average together
		Map<String, Double> summary = employees.stream()
				.collect(Collectors.teeing(Collectors.summingInt(Employee::getSalary),
						Collectors.averagingInt(Employee::getSalary), (sum, avg) -> {
							return Map.of("Total Salary", sum.doubleValue(), "Average Salary", avg);
						}));

		long count = employees.stream().count(); // get count separately

		// Print result
		System.out.println("Employee Count   : " + count);
		System.out.println("Total Salary     : ₹" + summary.get("Total Salary"));
		System.out.println("Average Salary   : ₹" + summary.get("Average Salary"));

	}
}

class Employee {
	private String name;
	private Integer salary;

	public Employee(String name, Integer salary) {
		super();
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}
}
