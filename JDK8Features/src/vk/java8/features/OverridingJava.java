package vk.java8.features;

import java.io.FileNotFoundException;
import java.io.IOException;

/*
 * 	Rules for Method Overriding
	Method signature must be the same (name, parameters, and return type).
	Access modifier cannot be more restrictive than the overridden method.
	Return type must be the same or covariant (i.e., subclass of the return type).
	Cannot override final methods.
	Cannot override static methods (this is called method hiding).
	Cannot override private methods (they are not inherited).
	Overriding method can throw fewer or narrower checked exceptions.
	Unchecked exceptions can be freely thrown.
	Use @Override annotation to ensure correctness (optional but recommended).
	Constructors cannot be overridden.
 */

public class OverridingJava {
	public static void main(String[] args) throws IOException {
		Parent p = new Child();
		System.out.println(p.m1("data"));
		float a = -24.5F;
		float b = -0;
		double a1 = -20.0D;
		double b1 = -0.0D;
// 1 
		float p1 = a / b;
		double p2 = a1 / b1;
		System.out.println(p1); // Because its follow IEEE 754
		System.out.println(p2);
		////////////////////////////
		Integer x = 100;
		Integer y = 100;
		Integer x1 = 200;
		Integer x2 = 200;
		System.out.println(".........");
		System.out.println(x == y); // ?
		System.out.println("int value " + (x1 == x2)); // ? 200 is outside the Integer cache range.
														// that's why false
		// - 127 to +128
		System.out.println(x.equals(y)); // true
		System.out.println(x1.equals(x2)); // true
		/////////////////////////////
		/*
		 * int x = 25; int y = 0; int z = x / y; Because integers don't follow IEEE 754,
		 * dividing by zero throws an exception. // ArithmeticExceptionf
		 */
		/*
		 * II double b = c -127 to 128 // memory allocation -127 to 128
		 */

		String s = "abc";
		String s1 = "abc";
		String s2 = new String("abc");
		System.out.println((s == s1));

		System.out.println(s.hashCode() == s1.hashCode());
		System.out.println(s.hashCode() == s2.hashCode());
		// I class override hash code but forget to equals method

	}
}

class Parent {
	protected String m1(Object data) throws IOException {
		return "Parent " + data;
	}
}

class Child extends Parent {
	@Override
	/*
	 * @Override public String m1(String data) throws FileNotFoundException { given
	 * error as no overriding as parameter is different, it's working
	 * without @Override but even without override , call parent method, which is
	 * not at all overriding.
	 */
	public String m1(Object data) throws FileNotFoundException {
		return "child " + data;
	}
}
