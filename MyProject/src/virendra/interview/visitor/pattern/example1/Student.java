package virendra.interview.visitor.pattern.example1;

public class Student extends Customer {

	public Student(String name) {
		super(name);
	}

	@Override
	public String toString() {
		return "Student (" + name + ")";
	}
	
}
