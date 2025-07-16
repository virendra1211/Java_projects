package org.ask.interview.coding;

import java.util.Collections;
import java.util.List;

public class ImmutableExample {
	public static void main(String[] args) {
		ImmutableStudent obj = new ImmutableStudent(1, "virendra", List.of("a"));
		System.out.println(obj);
		// obj.getCourses().add("virendra"); // if used UnSupotedOperationException
		// arise
	}
}

final class ImmutableStudent {
	private final int id;
	private final String name;
	private final List<String> courses;

	public ImmutableStudent(int id, String name, List<String> courses) {
		this.id = id;
		this.name = name;
		this.courses = Collections.unmodifiableList(courses);
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<String> getCourses() {
		return courses;
	}

	@Override
	public String toString() {
		return "ImmutableStudent [id=" + id + ", name=" + name + ", courses=" + courses + "]";
	}

}
