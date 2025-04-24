package vk.java8.features;

import java.util.Optional;

public class OptionalBindingExample {
    public static void main(String[] args) {
	Optional<String> optionalName = Optional.of("John Doe");

	// ? Using isPresent()
	if (optionalName.isPresent()) {
	    System.out.println("Name: " + optionalName.get());
	}

	// ? Using ifPresent() (Recommended)
	optionalName.ifPresent(name -> System.out.println("Hello, " + name));

	// ? Using orElse() (Default Value)
	String nameOrDefault = optionalName.orElse("Default Name");
	System.out.println("Name: " + nameOrDefault);

	// ? Using orElseGet() (Supplier)
	String generatedName = optionalName.orElseGet(() -> "Generated Name");
	System.out.println("Generated Name: " + generatedName);

	// ? Using orElseThrow() (Throws Exception if Empty)
	String mandatoryName = optionalName.orElseThrow(() -> new RuntimeException("Name not found"));
	System.out.println("Mandatory Name: " + mandatoryName);
    }
}
