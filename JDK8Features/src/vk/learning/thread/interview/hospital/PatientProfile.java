package vk.learning.thread.interview.hospital;

public class PatientProfile {
	private String name;
	private int age;
	private String insurance;

	// constructor, getters
	public PatientProfile(String name, int age, String insurance) {
		super();
		this.name = name;
		this.age = age;
		this.insurance = insurance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getInsurance() {
		return insurance;
	}

	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}
}
