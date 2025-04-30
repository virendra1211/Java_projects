package com.org.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.model.User;
import com.org.service.UserService;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

	@Autowired
	private UserService userService;

	// CREATE - POST
	@PostMapping
	public ResponseEntity<?> createUser(@RequestBody User user) {
		User created = userService.createUser(user);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(Map.of("message", "User created", "user", created));
	}

	// GET All Users
	@GetMapping
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	// GET User by ID
	@GetMapping("/{id}")
	public ResponseEntity<?> getUser(@PathVariable Long id) {
		return userService.getUser(id).map(user -> ResponseEntity.ok(user)).orElse(ResponseEntity
				.status(HttpStatus.NOT_FOUND).body(Map.of("error", "User not found")));
	}

	// UPDATE or CREATE (PUT)
	@PutMapping("/{id}")
	public ResponseEntity<?> putUser(@PathVariable Long id, @RequestBody User user) {
		boolean isUpdate = userService.exists(id);
		User savedUser = userService.saveOrUpdateUser(id, user);

		HttpStatus status = isUpdate ? HttpStatus.OK : HttpStatus.CREATED;
		String message = isUpdate ? "User updated successfully" : "User created successfully";

		return ResponseEntity.status(status).body(Map.of("message", message, "user", savedUser));
	}

	// DELETE User
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable Long id) {
		if (userService.deleteUser(id)) {
			return ResponseEntity.ok(Map.of("message", "User deleted"));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(Map.of("error", "User not found"));
		}
	}

	// PATCH (Optional partial update)
	@PatchMapping("/{id}")
	public ResponseEntity<?> patchUser(@PathVariable Long id,
			@RequestBody Map<String, Object> updates) {
		try {
			User updatedUser = userService.partialUpdateUser(id, updates);
			return ResponseEntity
					.ok(Map.of("message", "User partially updated", "user", updatedUser));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(Map.of("error", e.getMessage()));
		}
	}
}
