package com.org.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.org.security.JWTUtil;

@RestController
public class AuthController {

	@Autowired
	private JWTUtil jwtUtil;

	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping("/auth/login")
	public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {
		org.springframework.security.core.Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(),
						authRequest.getPassword()));

		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String accessToken = jwtUtil.generateToken(userDetails);
		String refreshToken = jwtUtil.generateRefreshToken(userDetails);

		Map<String, String> tokens = new HashMap<>();
		tokens.put("accessToken", accessToken);
		tokens.put("refreshToken", refreshToken);

		return ResponseEntity.ok(tokens);
	}

	@PostMapping("/auth/refresh")
	public ResponseEntity<?> refreshToken(@RequestBody Map<String, String> request) {
		String refreshToken = request.get("refreshToken");

		try {
			String username = jwtUtil.extractUsername(refreshToken);
			UserDetails userDetails = userDetailsService.loadUserByUsername(username);

			if (jwtUtil.validateToken(refreshToken, userDetails)) {
				String newAccessToken = jwtUtil.generateToken(userDetails);

				Map<String, String> tokens = new HashMap<>();
				tokens.put("accessToken", newAccessToken);
				tokens.put("refreshToken", refreshToken); // optionally issue new refresh token too

				return ResponseEntity.ok(tokens);
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid refresh token");
		}

		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token refresh failed");
	}
}

class AuthRequest {

	public Object getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

}