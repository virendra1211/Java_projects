package vk.learning.important.interview;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ObjectFieldValueIncrementPeek {

	public static void main(String[] args) {

		Employees[] arrayOfEngg = { new Employees(1, "Vivek Ojha", 100000),
				new Employees(2, "Shubhangi Jadhav", 200000),
				new Employees(3, "Gaurang Mangal", 300000) };

		List<Employees> enggList = Arrays.asList(arrayOfEngg);

		List<Employees> enggListOutput = enggList.stream().peek(e -> {
			e.setSalary(e.getSalary() + 19);
		}).collect(Collectors.toList());

		String[] str = { "Newa York", "Newb Jersey", "New Town" };
		Arrays.sort(str);
		System.out.println(Arrays.toString(str));
		List<String> ress = Arrays.asList(str).stream()
				.sorted(Comparator.comparing(g -> g.toString().split(" ")[1]))
				.collect(Collectors.toList());

		System.out.println("ressss " + ress);
		enggListOutput.forEach(System.out::println);
		/*
		 * List<Employees> employeeList = Arrays.asList(arrayOfEngg).stream()
		 * .map(employee -> employee.getSalary() + 1000).collect(Collectors.toList());
		 */

	}

}

class Employees {
	private Integer id;
	private String name;
	private long salary;

	public Integer getId() {
		return id;
	}

	public Object salaryIncrement(double d) {
		System.out.println(this.salary + d + "--");
		return this.salary + d;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}

	public long getSalary() {
		return salary;
	}

	public Employees(Integer id, String name, long salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

}
