package vk.learning.important.interview;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortNullBylast {
	public static void main(String[] args) {
		List<User> users = Arrays.asList(new User(1, "Zara"), new User(2, null), new User(3, "Bob"),
				new User(2, "Alice"), new User(6, null), new User(9, "Charlie"));

		List<User> result = users.stream()
				.sorted(Comparator.comparing(User::getName,
						Comparator.nullsLast(Comparator.naturalOrder())))
				.collect(Collectors.toList());
		result.forEach(System.out::println);

	}
}

class User {
	private Integer id;
	private String name;

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}

	public Integer getId() {
		return id;
	}

	public User(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
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
}