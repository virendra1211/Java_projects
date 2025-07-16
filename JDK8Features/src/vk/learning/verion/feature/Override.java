package vk.learning.verion.feature;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

class Parent {
	String getClassIdentifier() throws IOException, SQLException, FileNotFoundException, Exception { // working
		return null;
		// code to read file and connect to database
	}
}

// if child class defined in the different package then it will not work
class Child extends Parent {
	public String getClassIdentifier() throws RuntimeException {
		return "#89893_TEST_ID";
	}

}

public class Override {
	public static void main(String[] args)
			throws FileNotFoundException, IOException, SQLException, Exception {

		Parent p = new Parent();
		p.getClassIdentifier(); // need try catch here

		Child c = new Child();
		c.getClassIdentifier(); // not require

		Parent p1 = new Child(); // it should require try catch
		p1.getClassIdentifier();

	}
}

class Animal {
	void makeSound() {
	}
}

class Dog extends Animal {
	private void makeSound() {
	}
}

//////////////// I 
class A {
	Number getValue() throws IOException {
		return 42;
	}
}

class B extends A {
	Integer getValue() throws Exception {
		return 99;
	}
}

///////////// II
class Super {
	public final void doWork() {
		System.out.println("Working");
	}
}

class Sub extends Super {
	public void doWork() {
		System.out.println("Sub working");
	}
}

////////
class Parent1 {
	Object getData() {
		return new Object();
	}
}

class Child1 extends Parent1 {
	String getData() {
		return "Hello";
	}
}

// II 
class X {
	X() throws IOException {
		System.out.println("X constructor");
	}
}

class Y extends X {
	Y() throws IOException {

	}
}

class SuperClass {
	static void display() {
		System.out.println("SuperClass");
	}
}

class SubClass extends SuperClass {
	static void display() {
		System.out.println("SubClass");
	}
}

interface A {
	default void process() {
	}
}

abstract class B {
	abstract void process();
}

class C extends B implements A {
}

// vIII
interface A1 {
	default void process() {
	}
}

abstract class B1 {
	public abstract void process();
}

class C1 extends B1 implements A1 {
	public void process() {

	}
}