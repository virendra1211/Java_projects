package org.ask.interview.coding;

public class OverloadStaticMethodExample3 {
	public static void main(String args[]) {
		ParentClass pc = new ChildClass();
//calling display() method by parent class object  
		pc.display();
		pc.nonStaticMethod();
		/*
		 * ChildClass k= (ChildClass)new ParentClass(); k.display();
		 */
	}
}

//parent class  
class ParentClass {
//we cannot override the display() method  
	public static void display() {
		System.out.println("display() method of the parent class.");
	}
	public void nonStaticMethod() {
		System.out.println("nonStatic method parent");
	}
}

//child class  
class ChildClass extends ParentClass {
//the same method also exists in the ParentClass  
//it does not override, actually it is method hiding  
	public static void display() {
		System.out.println("Overridden static method in Child Class in Java");
	}
	public void nonStaticMethod() {
		System.out.println("nonStatic method child");
	}
}