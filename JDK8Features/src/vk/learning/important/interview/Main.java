package vk.learning.important.interview;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/*
Write a single stream that will find all unique words that start with the "#" symbol.
 
Input: "This JEP is #mainly for scientific #applications",
       "and it makes #floating-point operations consistently #strict.",
       "The default #floating-point operations are #strict or strictfp,",
       "both of which guarantee the same results from the #floating-point calculations on every platform."
 
Output: [#mainly, #applications, #floating-point, #strict]
*/

public class Main {
	public static void main(String[] args) {
		String[] input = new String[] { "This JEP is #mainly for scientific #applications",
				"and it makes #floating-point operations consistently #strict.",
				"The default #floating-point operations are #strict or strictfp,",
				"both of which guarantee the same results from the #floating-point calculations on every platform." };
		// put your solution below

		Set<String> set = Arrays.asList(input).stream().flatMap(p -> Arrays.stream(p.split(" ")))
				.filter(g -> g.startsWith("#")).collect(Collectors.toCollection(HashSet::new));

		System.out.println(set);

		Set<Person1> persons = new TreeSet<>((a, b) -> a.getName().compareTo(b.getName())); // class
																							// cast
																							// exception
		persons.add(new Person1(25, "Bob"));
		persons.add(new Person1(25, "Bob"));
		System.out.println(persons.size());

		Set<Person1> persons1 = new HashSet<>();
		persons1.add(new Person1(25, "Bob"));

	}
}

class Person1 {
	int age;
	String name;

	public int getAge() {
		return age;
	}

	public Person1(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person1 [age=" + age + ", name=" + name + "]";
	}

	// all args constructor

}
