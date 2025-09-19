package vk.learning.array.tough.interview;

import java.util.Comparator;
import java.util.List;

public class TopperStudentFindSumNum {

	public static void main(String[] args) {
		List<Student> studentList = List.of(new Student("bob", List.of(8, 3, 4)),
				new Student("alice", List.of(1, 2, 3)), new Student("craig", List.of(3, 4, 5)));

		Student result = studentList
				.stream().sorted(Comparator
						.comparingInt((Student s) -> s.marks().stream().mapToInt(n -> n).sum()).reversed())
				.findFirst().get();
		System.out.println(result.name());
		/*
		 * 
		 * select name, id, (sub1+sub2+sub3) As total_mark from student order by
		 * total_mark desc limit 1;
		 */
	}

}

record Student(String name, List<Integer> marks) {
}