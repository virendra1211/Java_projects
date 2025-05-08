package vk.learning.thread.interview.hospital;

import java.util.List;

public class MedicalHistoryService {
	public MedicalHistory getHistory(int id) {
		sleep(800);
		return new MedicalHistory(List.of("Hypertension", "Asthma"), List.of("Peanuts"));
	}

	private void sleep(long ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException ignored) {
		}
	}
}
