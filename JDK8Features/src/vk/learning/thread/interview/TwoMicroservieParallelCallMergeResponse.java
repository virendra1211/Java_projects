package vk.learning.thread.interview;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * Write a java program to fetch and aggregate employee information from two separate services : 
 * 1. an employee profile service that returns basic information,
 * 2. A employee past experience service that returns the employee prior experience . 
 * 3. call both service asynchrhnously and in parallel, aggregates the result into a single response object,
 * 4. always wait for both service calls toe complete before responding
 * Separate knowledge base:
 * 	Uses CompletableFuture.supplyAsync to call services in parallel.
	Uses thenCombine to merge the results into a single EmployeeFullInfo.
	Uses .join() to block until everything is done (can also use .get() if preferred).
 */
public class TwoMicroservieParallelCallMergeResponse {
	public static void main(String[] args) {
		int employeeId = 101;
		EmployeeProfileService profileService = new EmployeeProfileService();
		EmployeeExperienceService experienceService = new EmployeeExperienceService();

		ExecutorService executor = Executors.newFixedThreadPool(2); // separate executor we just use
																	// for resource intensive task

		CompletableFuture<EmployeeProfile> profileFuture = CompletableFuture
				.supplyAsync(() -> profileService.getProfile(employeeId), executor);

		CompletableFuture<EmployeeExperience> experienceFuture = CompletableFuture
				.supplyAsync(() -> experienceService.getExperience(employeeId), executor);

		// Combine results after both complete
		CompletableFuture<EmployeeFullInfo> combinedFuture = profileFuture
				.thenCombine(experienceFuture, EmployeeFullInfo::new);

		// Wait and print the result
		combinedFuture.thenAccept(fullInfo -> {
			System.out.println("Aggregated Employee Info:");
			System.out.println(fullInfo);
		}).join(); // Waits for completion

		executor.shutdown();

	}

}

class EmployeeProfile {
	int id;
	String name;
	String email;

	public EmployeeProfile(int id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}
}

class EmployeeExperience {
	List<String> experiences;

	public EmployeeExperience(List<String> experiences) {
		this.experiences = experiences;
	}
}

class EmployeeFullInfo {
	int id;
	String name;
	String email;
	List<String> experiences;

	public EmployeeFullInfo(EmployeeProfile profile, EmployeeExperience experience) {
		this.id = profile.id;
		this.name = profile.name;
		this.email = profile.email;
		this.experiences = experience.experiences;
	}

	@Override
	public String toString() {
		return "EmployeeFullInfo{" + "id=" + id + ", name='" + name + '\'' + ", email='" + email
				+ '\'' + ", experiences=" + experiences + '}';
	}
}

//--- Services ---
class EmployeeProfileService {
	public EmployeeProfile getProfile(int employeeId) {
		// Simulate delay
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new EmployeeProfile(employeeId, "Alice Smith", "alice@example.com");
	}
}

class EmployeeExperienceService {
	public EmployeeExperience getExperience(int employeeId) {
		// Simulate delay
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new EmployeeExperience(Arrays.asList("Google", "Amazon", "Startup X"));
	}
}
