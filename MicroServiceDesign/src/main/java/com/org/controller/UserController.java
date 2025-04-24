package com.org.controller;

import java.util.List;
import java.util.Map;

import org.apache.hc.core5.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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

    @PutMapping("/{id}")
    public ResponseEntity<?> putUser(@PathVariable Long id, @RequestBody User user) {
	boolean isUpdate = userService.exists(id);
	User savedUser = userService.saveOrUpdateUser(id, user);

	if (isUpdate) {
	    return ResponseEntity.ok(Map.of("message", "User updated successfully", "user", savedUser));
	} else {
	    return ResponseEntity.status(HttpStatus.SC_CREATED)
		    .body(Map.of("message", "User created successfully", "user", savedUser));
	}
    }

    // Create User
    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user) {
	User created = userService.createUser(user);
	return ResponseEntity.status(HttpStatus.SC_CREATED).body(Map.of("message", "User created", "user", created));
    }

    // Get All Users
    @GetMapping
    public List<User> getAllUsers() {
	return userService.getAllUsers();
    }

    // Get User by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id) {
	return userService.getUser(id).map(user -> ResponseEntity.ok(user))
		.orElse(ResponseEntity.status(HttpStatus.SC_NOT_FOUND).body(Map.of("error", "User not found")));
    }

    // Update or Create (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody User user) {
        try {
            User updated = userService.updateUser(id, user);
            boolean isUpdate = userService.getUser(id).isPresent();
            return ResponseEntity.status(isUpdate ? HttpStatus.OK : HttpStatus.CREATED).body(Map.of(
                "message", isUpdate ? "User updated" : "User created",
                "user", updated
            ));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of("error", e.getMessage()));
        }

    // Delete User
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
	if (userService.deleteUser(id)) {
	    return ResponseEntity.ok(Map.of("message", "User deleted"));
	} else {
	    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", "User not found"));
	}
    }

}