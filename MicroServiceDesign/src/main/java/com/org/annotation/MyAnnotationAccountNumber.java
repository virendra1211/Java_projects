package com.org.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;
import jakarta.validation.Valid;

public class MyAnnotationAccountNumber {

}

//@RestController
// @RequestMapping("/users")
class UserController {

	// @PostMapping
	public ResponseEntity<String> createUser(@Valid @RequestBody UserRequest userRequest) {
		return ResponseEntity.ok("Valid user: " + userRequest.getUsername());
	}
}

class UserRequest {

	@NoSpecialChars(message = "Username must not contain special characters")
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	// getters and setters
}

// Create the Annotation
// ✅ Step 1: Create the Annotation
@Documented
@Constraint(validatedBy = NoSpecialCharsValidator.class)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@interface NoSpecialChars {
	String message() default "Special characters are not allowed";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}

// ✅ Step 2: Create the Validator Class
class NoSpecialCharsValidator implements ConstraintValidator<NoSpecialChars, String> {

	private static final String REGEX = "^[a-zA-Z0-9 ]*$"; // letters, digits, spaces

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return value == null || value.matches(REGEX);
	}
}
