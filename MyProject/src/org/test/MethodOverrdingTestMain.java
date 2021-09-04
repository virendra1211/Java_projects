package org.test;

import java.io.IOException;

/*

compile time error
 
Explanation:
As exception thrown by overridden method can not be more restrictive, it will result in compile time error.

*/
public class MethodOverrdingTestMain {
	public static void main(String[] args) {
		B11 b = new B11();
		try {
			b.method();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

class A11 {

	public void method() throws IOException {

	}
}

class B11 extends A11 {

	public void method() throws Exception {

	}
}
