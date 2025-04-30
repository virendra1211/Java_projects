package com.org.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.org.model.User;
import com.org.service.UserService;

@RestController
@RequestMapping("/api/v1/users") // VERSIONING
public class UserControllerWithManyFeature {

	@Autowired
	private UserService userService;

	// CREATE - POST
	@PostMapping
	public ResponseEntity<?> createUser(@RequestBody User user) {
		User created = userService.createUser(user);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(Map.of("message", "User created", "user", created));
	}

	// GET All Users with FILTERING, SORTING, PAGINATION
	@GetMapping
	@Cacheable(value = "usersCache") // CACHING
	public ResponseEntity<?> getAllUsers(@RequestParam(required = false) String name,
			@RequestParam(required = false) String email,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size,
			@RequestParam(defaultValue = "id,asc") String[] sort) {

		// Parse sort params
		Sort.Direction direction = sort[1].equalsIgnoreCase("desc") ? Sort.Direction.DESC
				: Sort.Direction.ASC;
		Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sort[0]));

		Page<User> users = userService.getAllUsers(name, email, pageable);
		return ResponseEntity.ok(users);
	}

	// GET User by ID
	@GetMapping("/{id}")
	@Cacheable(value = "userCache", key = "#id") // CACHING
	public ResponseEntity<?> getUser(@PathVariable Long id) {
		return userService.getUser(id).map(user -> ResponseEntity.ok(user))
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
	}

	// UPDATE or CREATE (PUT)
	@PutMapping("/{id}")
	@CacheEvict(value = { "usersCache", "userCache" }, allEntries = true) // CLEAR CACHE
	public ResponseEntity<?> putUser(@PathVariable Long id, @RequestBody User user) {
		boolean isUpdate = userService.exists(id);
		User savedUser = userService.saveOrUpdateUser(id, user);

		HttpStatus status = isUpdate ? HttpStatus.OK : HttpStatus.CREATED;
		String message = isUpdate ? "User updated successfully" : "User created successfully";

		return ResponseEntity.status(status).body(Map.of("message", message, "user", savedUser));
	}

	// DELETE User
	@DeleteMapping("/{id}")
	@CacheEvict(value = { "usersCache", "userCache" }, allEntries = true) // CLEAR CACHE
	public ResponseEntity<?> deleteUser(@PathVariable Long id) {
		if (userService.deleteUser(id)) {
			return ResponseEntity.ok(Map.of("message", "User deleted"));
		} else {
			throw new ResourceNotFoundException("User not found with id " + id);
		}
	}

	// PATCH (Optional partial update)
	@PatchMapping("/{id}")
	@CacheEvict(value = { "usersCache", "userCache" }, allEntries = true) // CLEAR CACHE
	public ResponseEntity<?> patchUser(@PathVariable Long id,
			@RequestBody Map<String, Object> updates) {
		User updatedUser = userService.partialUpdateUser(id, updates);
		return ResponseEntity.ok(Map.of("message", "User partially updated", "user", updatedUser));
	}
}
