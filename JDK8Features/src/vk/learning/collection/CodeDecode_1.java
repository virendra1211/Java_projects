package vk.learning.collection;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class CodeDecode_1 {
	public static void main(String[] args) {
		groupingBy();
		frequency();
	}

	private static void frequency() {
		List<Integer> list = Arrays.asList(1, 2, 3, 5, 6);
		IntSummaryStatistics result = list.stream().mapToInt(Integer::intValue).summaryStatistics();
		System.out.println(result);
	}

	public static void groupingBy() {
		List<Employee1> list = Arrays.asList(new Employee1(1, "code1", 30), new Employee1(2, "code2", 35),
				new Employee1(3, "code", 30), new Employee1(4, "decode", 28), new Employee1(5, "code", 30));

		Map<Integer, Set<Employee1>> result = list.stream()
				.collect(Collectors.groupingBy(Employee1::getAge, TreeMap::new, Collectors.toSet()));
		result.forEach((k, v) -> {
			System.out.println(k + " - " + v);
		});

	}
}

class Employee1 {
	public Employee1(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Employee1 [id=" + id + ", name=" + name + ", age=" + age + "]";
	}

	public String getName() {
		return name;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee1 other = (Employee1) obj;
		return Objects.equals(name, other.name);
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	private int id;
	private String name;
	private int age;

}