package vk.learning.thread.interview.hospital;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PatientParallelCall {

	private ProfileService profileService;
	private MedicalHistoryService historyService;
	private AppointmentService appointmentService;

	private final static ExecutorService executor = Executors.newFixedThreadPool(3);

	public static void main(String[] args) {
		ProfileService profileService;
		MedicalHistoryService historyService;
		AppointmentService appointmentService;
		profileService = new ProfileService();
		historyService = new MedicalHistoryService();
		appointmentService = new AppointmentService();

		int id = 123;
		CompletableFuture<PatientProfile> profileFuture = CompletableFuture
				.supplyAsync(() -> profileService.getProfile(id), executor);

		CompletableFuture<MedicalHistory> historyFuture = CompletableFuture.supplyAsync(() -> {
			try {
				return historyService.getHistory(id);
			} catch (Exception e) {
				System.out.println("MedicalHistoryService failed: " + e.getMessage());
				return new MedicalHistory(List.of(), List.of());
			}
		}, executor);

		CompletableFuture<List<Appointment>> appointmentFuture = CompletableFuture
				.supplyAsync(() -> appointmentService.getAppointments(id), executor);

		CompletableFuture.allOf(profileFuture, historyFuture, appointmentFuture).join();

		System.out.println(new PatientDashboard(profileFuture.join(), historyFuture.join(),
				appointmentFuture.join()));
	}

}
