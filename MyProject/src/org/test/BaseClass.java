package org.test;

/*
 What are Covariant return type in java?
Covariant return type means if subclass overrides any method, return type of this overriding method can
 be subclass of return type of base class method.

 */
public class BaseClass {

	public A m1() {
		System.out.println("In BaseClass method");
		return new A();
	}

	public static void main(String args[]) {
		BaseClass b = new SubClass();
		b.m1();
	}
}

class SubClass extends BaseClass {
	public B m1() {
		System.out.println("In SubClass method");
		return new B();

	}
}

class A {
}

class B extends A {

}