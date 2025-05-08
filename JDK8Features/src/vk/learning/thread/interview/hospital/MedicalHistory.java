package vk.learning.thread.interview.hospital;

import java.util.List;

public class MedicalHistory {
	private List<String> conditions;
	private List<String> allergies;

	// constructor, getters
	public List<String> getConditions() {
		return conditions;
	}

	public MedicalHistory(List<String> conditions, List<String> allergies) {
		super();
		this.conditions = conditions;
		this.allergies = allergies;
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
}
