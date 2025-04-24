package basic.topic.interview;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

import org.serializable.Employee;

public class TreeSetSort {
	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(j + i+" ");
			}
			System.out.println();

		}
		Set<Employee> set = new TreeSet<>();
		set.add(new Employee(5, "ram", "1khade"));
		set.add(new Employee(3, "ram3", "2khade"));
		set.add(new Employee(1, "ram1", "4khade"));
		set.add(new Employee(2, "ram2", "3khade"));
		set.add(new Employee(4, "ram4", "5khade"));

		for (Employee e : set) {
			System.out.println(e.getId() + " - " + e.getName() + " - " + e.getLname());
		}
	}
}
