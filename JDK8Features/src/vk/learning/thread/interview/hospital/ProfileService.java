package vk.learning.thread.interview.hospital;

public class ProfileService {
	public PatientProfile getProfile(int id) {
		sleep(400);
		return new PatientProfile("John Doe", 45, "HealthPlus Insurance");
	}

	private void sleep(long ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException ignored) {
		}
	}
}
