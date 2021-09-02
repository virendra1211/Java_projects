package org.test;

/*
 output: Calling String method
	When we have two overloaded version of same method, JVM will always call most specific method.

 */
public class MethodOverloadingExample {

	public void methodTest(Object object) {
		System.out.println("Calling object method");
	}

	public void methodTest(String object) {
		System.out.println("Calling String method");
	}

	public static void main(String args[]) {
		MethodOverloadingExample moe = new MethodOverloadingExample();
		moe.methodTest(null);
	}
}