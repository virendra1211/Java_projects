package vk.learning.thread.interview;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Employee {
	int id;
	String name;
	int salary;
	String dept;

	Employee(int id, String name, int salary, String dept) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Employee{id=" + id + ", name='" + name + '\'' + ", salary=" + salary + ", dept='"
				+ dept + '\'' + '}';
	}
}

public class SecondHighestSalary {
	public static void main(String[] args) {
		List<Employee> employees = Arrays.asList(new Employee(1, "Shivam", 5000, "SSE"),
				new Employee(5, "abc", 4000, "SSE"), new Employee(2, "Sharma", 8000, "SE"),
				new Employee(3, "sumit", 8000, "SSE"), new Employee(4, "kumar", 10000, "Manager"),
				new Employee(6, "abc", 10000, "SSE"));

		// Single stream to get second highest salaried employee(s)
		List<Employee> secondHighestSalaried = employees.stream().map(e -> e.salary).distinct()
				.sorted(Comparator.reverseOrder()).skip(1).findFirst()
				.map(secondHighSalary -> employees.stream()
						.filter(e -> e.salary == secondHighSalary).collect(Collectors.toList()))
				.orElse(Collections.emptyList());

		// Print the result
		secondHighestSalaried.forEach(System.out::println);
	}
}
