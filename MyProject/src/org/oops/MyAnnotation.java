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
    }

}

@Retention(RetentionPolicy.RUNTIME)
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