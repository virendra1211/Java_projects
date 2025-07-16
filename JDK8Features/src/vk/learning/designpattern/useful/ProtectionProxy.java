package vk.learning.designpattern.useful;

public class ProtectionProxy {
	public static void main(String[] args) {
		SecurityProxy adminProxy = new SecurityProxy("Admin");
		adminProxy.accessData(); // Access allowed
		SecurityProxy userProxy = new SecurityProxy("User");
		userProxy.accessData(); // Access denie
	}
}

class SensitiveData {
	public void accessData() {
		System.out.println("Accessing sesitvie data...");
	}
}

class SecurityProxy {
	SensitiveData sensitiveData;
	private String userRole;

	public SecurityProxy(String userRole) {
		this.userRole = userRole;
		sensitiveData = new SensitiveData();
	}

	public void accessData() {
		if ("Admin".equals(userRole)) {
			sensitiveData.accessData();
		} else {
			System.out.println("Access denied: Insufficient Permission");
		}
	}

}
/*
 * Explanation: • SensitiveData is the real object that can access sensitive
 * information. • SecurityProxy checks the user's role and controls access to
 * SensitiveData . Only users with the "Admin" role can access the data
 */