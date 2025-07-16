package vk.learning.practice;

public class DiamondProblemAndAutoClose {

	public static void main(String[] args) {
		A obj = new D();
		obj.sayHello();

	}

}

interface A {
	default void sayHello() {
		System.out.println("Hello from A");
	}
}

interface B extends A {
	default void sayHello() {
		System.out.println("Hello from B");

		try (MyResource res = new MyResource()) {
			res.doWork();
		}

	}
}

interface C extends A {
	default void sayHello() {
		System.out.println("Hello from C");
	}
}

class D implements B, C {
	@Override
	public void sayHello() {
		B.super.sayHello(); // or C.super.sayHello();
	}
}

class MyResource implements AutoCloseable {
	public void doWork() {
		System.out.println("Working...");
	}

	@Override
	public void close() {
		System.out.println("Closed!");
	}
}
