package vk.java8.stream.problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/*
 * Question:
 * Sort a list of users by name alphabetically, but put users with "null names at the end.
 */
public class CustomerSortingWithnullStream {

	public static void main(String[] args) {
		List<User> users = Arrays.asList(new User(1, "Zara"), new User(2, null), new User(3, "Bob"),
				new User(2, "Alice"), new User(6, null), new User(9, "Charlie") // Duplicate ID
		);

		List<User> result = users.stream().filter(CustomerSortingWithnullStream::isValidName)
				.sorted(Comparator.comparing(User::getName)).collect(Collectors.toList());

		result.forEach(System.out::println);

		List<String> list = Arrays.asList("A", "G", "E", "E", "B", "G", "E");
		Set<String> duplicateValue = new HashSet<String>();
		Set<String> setList = list.stream().filter(p -> !duplicateValue.add(p.toString()))
				.collect(Collectors.toSet());
		setList.forEach(System.out::println);

	}

	public static boolean isValidName(User user) {
		return user.getName() != null && user.getName().trim().length() > 0;
	}

}
