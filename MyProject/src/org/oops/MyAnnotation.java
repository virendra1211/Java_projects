package org.oops;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class MyAnnotation {
	public static void main(String[] args) {
		Class<?> nestedClass = Service.TaskProcessor.class;

		// Check if annotation is present
		if (nestedClass.isAnnotationPresent(ProcessThis.class)) {
			ProcessThis annotation = nestedClass.getAnnotation(ProcessThis.class);
			System.out.println("Annotation found! Value = " + annotation.value());
		} else {
			System.out.println("No annotation found.");
		}

		MyGeneric<Integer, Integer, Integer, Integer> bb = (a, b, c) -> a + b + c;
		System.out.println(bb.sum(5, 3, 6));
		myMethod((a, b, c) -> a + b + c);
	}

	public static void myMethod(MyGeneric<Integer, Integer, Integer, Integer> bb) {
		System.out.println(bb.sum(5, 5, 5));

	}

}
// marker serializable, cloneable, Documented
/*
 * without constraints nothing happened, you need to do this by our own
 */

@Retention(RetentionPolicy.RUNTIME)
//@Target({ ElementType.FIELD })
@interface ProcessThis {
	String value() default "default";
}

class Service {

	@ProcessThis("Nested Task")
	public static class TaskProcessor {
		public void run() {
			System.out.println("Test");
		}
	}
}

interface MyGeneric<A, B, C, D> {
	A sum(B b, C c, D d);
}