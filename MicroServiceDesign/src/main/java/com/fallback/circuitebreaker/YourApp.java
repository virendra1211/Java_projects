package com.fallback.circuitebreaker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.metrics.buffering.BufferingApplicationStartup;

//@EnableCircuitBreaker
@SpringBootApplication // (exclude = {className.class})
public class YourApp {
	public static void main(String[] args) {
		SpringApplication.run(YourApp.class, args);
		SpringApplication sppringApplication = new SpringApplication();
		sppringApplication.setApplicationStartup(new BufferingApplicationStartup(2046));
	}
}
// Java 17 class data sharing, parallel class loading.

interface A {
	default void sayHello() {
		System.out.println("Hello from A");
	}
}

interface B extends A {
	default void sayHello() {
		System.out.println("Hello from B");
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
		B.sayHello(); // or C.super.sayHello();
	}
}
