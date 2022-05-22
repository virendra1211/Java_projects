package virendra.interview.visitor.pattern.example1;

public class Person extends Customer {

	public Person(String name) {
		super(name);
	}

	@Override
	public String toString() {
		return "Person (" + name + ")";
	}

}
