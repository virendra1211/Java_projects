package vk.java8.stream.problems;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConvertToMapByUser {

	public static void main(String[] args) {
		List<User> users = Arrays.asList(new User(1, "Alice"), new User(2, "Bob"),
				new User(3, "Charlie"), new User(2, "David") // Duplicate ID
		);

		Map<Integer, String> mapAns = users.stream()
				.collect(Collectors.toMap(User::getId, User::getName, (n, m) -> n + "/" + m));

		System.out.println(mapAns);
	}

}

class User {
	int id;
	String name;

	User(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}

}
