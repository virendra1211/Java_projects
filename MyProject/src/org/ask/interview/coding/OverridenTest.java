package org.ask.interview.coding;

import java.io.FileNotFoundException;

/**
 * animal a = cat animal ea- throw file not found frog - exception. to avoid
 * call. class cast exception ayenga
 * 
 * in sub class access specifier should be less restrictive
 * 
 * 
 * @author Virendra khade
 * 
 */
public class OverridenTest {
	public static void main(String[] args) throws Exception {
		A1 obj = new A2();
		obj.m1("abc");
	}
}

class A1 {
	protected A1 m1(String... s) throws Exception {
		System.out.println("A1");
		return null;
	}

}

class A2 extends A1 {

	public A2 m1(String... s) throws FileNotFoundException { // in the sub class access specifier
		System.out.println("A2");
		return null;
	}

}

interface I1 {
	default void show() {
		System.out.println("**I1**");
	}
}

interface I2 {
	default void show() {
		System.out.println("**I2**");
	}
}

class A {
	void show() {
		System.out.println("**C**");
	}
}

class C extends A implements I1 {
	public void show() {
		System.out.println("**C**");
	}
}
