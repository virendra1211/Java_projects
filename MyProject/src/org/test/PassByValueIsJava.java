package org.test;

import java.util.ArrayList;
import java.util.List;

public class PassByValueIsJava {
	public static void main(String[] args) {
		myReference();
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		// List.of("a","d","e");
		System.out.println(list);
		myPass(list);
		System.out.println("after pass by "+list);
		// II pass by value in the below example
		Integer y = 5;
		System.out.println(y); // prints "5"
		myMethod(y);
		System.out.println(y); // prints "5"
		// pass by reference start
		// copy of the value store in the argument not an original argument.

		Person person1 = new Person("A", 21);

		Person person2;
		person2 = person1;

		person2.changeDetails("BBB", 30);
		System.out.println("after "+person1);

		// Person1 ----------> A,21
		// 1234

		// person2
		// null then 1234
		// person2 pointing to same object data as person1

		person2 = person1;
		// person2 pointing to the object "A,21" and change to "BBB"

		// we won't get A,21
		// pass by reference end
	}

	public static void myMethod(int x) {
		x = 4; // myMethod has a copy of x, so it doesn't overwrite the value of variable y
				// used
				// in main() that called myMethod
	}

	private static void myPass(List<String> list) {
		List<String> l = list;
		l.add("p");
		l.add("gl");
	}
	private static void myReference() {
		Person aDog = new Person("Max",11);
	    Person oldDog = aDog;

	    // we pass the object to foo
	    foo(aDog);
	    // aDog variable is still pointing to the "Max" dog when foo(...) returns
	    System.out.println("  aDog.getName().equals(\"Max\") "+  aDog.getName().equals("Max")); // true
	    System.out.println(" aDog.getName().equals(\"Fifi\") "+aDog.getName().equals("Fifi")); // false
	    System.out.println(aDog = oldDog); // true
	}
	public static void foo(Person d) {
	    d.getName().equals("Max"); // true
	    // change d inside of foo() to point to a new Dog instance "Fifi"
	    d = new Person("Fifi",133);
	    d.getName().equals("Fifi"); // true
	}
	
}

class Person {
	private String name;
	private Integer id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Person(String name, Integer id) {
		super();
		this.name = name;
		this.id = id;
	}

	public void changeDetails(String string, int i) {
		this.name = string;
		this.id = i;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", id=" + id + "]";
	}

}