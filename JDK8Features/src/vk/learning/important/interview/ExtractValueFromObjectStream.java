package vk.learning.important.interview;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ExtractValueFromObjectStream {

	public static void main(String[] args) {
		List<Person> people = Arrays.asList(new Person("Alice", "Marie", "Smith", null),
				new Person("Bob", null, "Jones", Gender.MALE),
				new Person("Clara", null, "White", Gender.FEMALE),
				new Person("Diana", "Rose", "Brown", Gender.FEMALE));

		List<String> middleNames = people.stream().filter(p -> p.getGender() == Gender.FEMALE)
				.map(Person::getMiddleName).filter(Objects::nonNull).map(String::toUpperCase)
				.collect(Collectors.toList());
		System.out.println(middleNames);

	}

}

class Person {
	private String firstName;
	private String middleName;

	public Person(String firstName, String middleName, String lastName, Gender gender) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.gender = gender;
	}

	private String lastName;
	private Gender gender;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

}

public enum Gender {
	MALE, FEMALE, OTHER
}