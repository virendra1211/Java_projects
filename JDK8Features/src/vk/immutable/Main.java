package vk.immutable;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<Address> addressList = new ArrayList<>();
		addressList.add(new Address("New York", "5th Avenue"));
		addressList.add(new Address("Los Angeles", "Sunset Blvd"));

		Employee emp = new Employee("Alice", 101, addressList);
		System.out.println("Original Employee: " + emp);

		// Try modifying the original list after Employee is created
		addressList.add(new Address("Chicago", "Michigan Ave"));
		System.out.println("After modification attempts: " + emp);
		// Try modifying the returned list from getter
		List<Address> retrievedAddresses = emp.getAddresses();
		try {
			retrievedAddresses.add(new Address("Houston", "Main St"));
		} catch (UnsupportedOperationException e) {
			System.out.println("Modification attempt blocked: " + e);
		}

		System.out.println("After modification attempts: " + emp);
	}
}