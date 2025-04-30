package vk.learning.important.interview;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

public class StreamMapOtherObject {
	public static void main(String[] args) {
		Integer[] empIds = { 1, 2, 3, 4 };
		EmployeeRepository employeeRepository = new EmployeeRepository();
		Employee1 employee = Stream.of(empIds)
				.map(employeeRepository::findById)
				.filter(Objects::nonNull)
				.filter(e -> e.getSalary() > 100000).findFirst()
				.orElse(null);

		System.out.println(employee);

	}
}

class EmployeeRepository {
	private Map<Integer, Employee1> employeeData = new HashMap<>();

	// Just for illustration: constructor to populate some data
	public EmployeeRepository() {
		employeeData.put(1, new Employee1(1, "John Doe", 120000));
		employeeData.put(2, new Employee1(2, "Jane Smith", 90000));
		employeeData.put(3, new Employee1(3, "Jim Brown", 150000));
		employeeData.put(4, new Employee1(4, "Jake White", 95000));
	}

	// Find by ID method
	public Employee1 findById(Integer id) {
		return employeeData.get(id);
	}
}

class Employee1 {
	private Integer id;
	private String name;

	@Override
	public String toString() {
		return "Employee1 [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}

	private double salary;

	public Employee1(Integer id, String name, double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}
}
