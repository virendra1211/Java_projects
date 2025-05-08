package vk.learning.thread.interview.hospital;

import java.util.List;

public class AppointmentService {
	public List<Appointment> getAppointments(int id) {
		sleep(1000);
		return List.of(new Appointment("2024-05-10", "Dr. Smith", "Cardiology"),
				new Appointment("2024-05-20", "Dr. Jane", "Pulmonology"));
	}

	private void sleep(long ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException ignored) {
		}
	}
}
