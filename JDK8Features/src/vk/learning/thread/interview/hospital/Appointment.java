package vk.learning.thread.interview.hospital;

public class Appointment {
	private String date;
	private String doctor;
	private String department;

	// constructor, getters
	public Appointment(String date, String doctor, String department) {
		super();
		this.date = date;
		this.doctor = doctor;
		this.department = department;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
}
