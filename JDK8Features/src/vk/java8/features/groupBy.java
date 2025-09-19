package vk.java8.features;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class groupBy {
	public static void main(String[] args) {
		Student s1 = new Student(1, "a", "IIT");
		Student s2 = new Student(1, "a", "NIIT");
		Student s3 = new Student(2, "a", "IIT");
		Student s4 = new Student(2, "a", "NII");
		Student s5 = new Student(1, "a", "IIT");
		Student s6 = new Student(3, "a", "ICS");
		Student s7 = new Student(1, "a", "IIT");

		List<Student> list = Arrays.asList(s1, s2, s3, s4, s5, s6, s7);
		Map<String, List<Student>> map = list.stream().collect(Collectors.groupingBy(Student::getCollegeId));
		for (Entry m1 : map.entrySet()) {
			System.out.println(m1.getKey());
			List<Student> l1 = (List<Student>) m1.getValue();
			for (Student s : l1) {
				System.out.println(s.getId() + " " + s.getName() + " " + s.getCollegeId());
			}
		}

		// 1. group of array segregate in a way like below input and answer would be
		// {0[2], 50=[54,59],10=[11,19],30[34,33,37]}
		int[] arr = { 2, 34, 54, 23, 33, 20, 59, 11, 19, 37 };
		groupToSegregateBasedOnRange(arr);

	}

	private static void groupToSegregateBasedOnRange(int[] arr) {
		// one way state forwared map.computeIfAbscent we can use// {0[2],
		// 50=[54,59],10=[11,19],30[34,33,37]}
		Map<Integer, List<Integer>> grouped = Arrays.stream(arr).boxed()
				.collect(Collectors.groupingBy(n -> (n / 10) * 10, HashMap::new, Collectors.toList()));
		System.out.println(grouped);

	}
}

class Student {
	private int id;
	private String name;
	private String collegeId;

	public Student(int id, String name, String collegeId) {
		super();
		this.id = id;
		this.name = name;
		this.collegeId = collegeId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(String collegeId) {
		this.collegeId = collegeId;
	}

}
