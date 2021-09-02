package org.test;

public class ClassCallTest {
	public static void main(String[] args) {
		
		// I question, can i call static method
		A1 a = null;
		a.method();
		// II can i use this, answer is false, it's true when initialize a
		if(a instanceof A1) {
			System.out.println("with Null reference");
		}else {
			System.out.println("without null reference");
		}
	}
}

class A1{
		static void method() {
			System.out.println("static method called");
		}
}

class B1 extends A1 {
	
}
