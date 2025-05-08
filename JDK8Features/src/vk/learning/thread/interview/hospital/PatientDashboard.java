package vk.learning.thread.interview.hospital;

import java.util.List;

public class PatientDashboard {
	private String name;
	private int age;
	private String insurance;
	private List<String> conditions;
	private List<String> allergies;
	private List<Appointment> upcomingAppointments;

	public PatientDashboard(PatientProfile profile, MedicalHistory history,
			List<Appointment> appts) {
		this.name = profile.getName();
		this.age = profile.getAge();
		this.insurance = profile.getInsurance();
		this.conditions = history.getConditions();
		this.allergies = history.getAllergies();
		this.upcomingAppointments = appts;
	}

	public PatientDashboard(String name, int age, String insurance, List<String> conditions,
			List<String> allergies, List<Appointment> upcomingAppointments) {
		super();
		this.name = name;
		this.age = age;
		this.insurance = insurance;
		this.conditions = conditions;
		this.allergies = allergies;
		this.upcomingAppointments = upcomingAppointments;
	}

	@Override
	public String toString() {
		return "PatientDashboard [name=" + name + ", age=" + age + ", insurance=" + insurance
				+ ", conditions=" + conditions + ", allergies=" + allergies
				+ ", upcomingAppointments=" + upcomingAppointments + "]";
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

	public List<String> getConditions() {
		return conditions;
	}

	public void setConditions(List<String> conditions) {
		this.conditions = conditions;
	}

	public List<String> getAllergies() {
		return allergies;
	}

	public void setAllergies(List<String> allergies) {
		this.allergies = allergies;
	}

	public List<Appointment> getUpcomingAppointments() {
		return upcomingAppointments;
	}

	public void setUpcomingAppointments(List<Appointment> upcomingAppointments) {
		this.upcomingAppointments = upcomingAppointments;
	}
}
