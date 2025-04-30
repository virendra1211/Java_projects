package vk.immutable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Employee {
	private final String name;
	private final int id;
	private final List<Address> addresses;

	public Employee(String name, int id, List<Address> addresses) {
		this.name = name;
		this.id = id;
		// Defensive copy and unmodifiable list
		this.addresses = Collections.unmodifiableList(new ArrayList<>(addresses));
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public List<Address> getAddresses() {
		return addresses; // Already unmodifiable
		// return new ArrayList<>(addresses); // Defensive copy
	}

	@Override
	public String toString() {
		return "Employee{id=" + id + ", name='" + name + "', addresses=" + addresses + "}";
	}
}