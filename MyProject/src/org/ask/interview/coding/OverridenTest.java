package org.ask.interview.coding;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * animal a = cat animal ea- throw file not found frog - exception. to avoid
 * call. class cast exception ayenga
 * 
 * in sub class access specifier should be less restrictive
 
 
 * @author Virendra khade
 * 
 */
public class OverridenTest {
	public static void main(String[] args) {
		
	}
}

class A1 {
	 A2 m1(String... s) throws Exception {
		return null;
	}
	
}

class A2 extends A1 {

	 protected A2 m1(String... s) throws FileNotFoundException {
		return null;
	 }
	 
}


interface I1{
	default void show() {
		System.out.println("**I1**");
	}
}
interface I2{
	default void show() {
		System.out.println("**I2**");
	}
}
class A{
	void show() {
		System.out.println("**C**");
	}
}
class C extends A implements I1{
	public void show() {
		System.out.println("**C**");
	}
}
