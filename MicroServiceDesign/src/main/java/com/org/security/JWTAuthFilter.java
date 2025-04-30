package com.org.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*
"When a user logs in via /auth/login, we authenticate their credentials and generate a JWT token using our JWTUtil class. 
The token includes their username and expiration time, signed with a secret key. This token is returned to the client,
 who stores it locally. For all subsequent requests, the client sends the token in the Authorization header as a Bearer token.
On each request, a JWT filter intercepts it, validates the token using JWTUtil, and if valid, sets the user’s
authentication in the Spring Security context, allowing them to access protected endpoints.
 This flow is stateless — no session is maintained on the server."
 
 should explain 
- Mention statelessness of JWT (no server memory required).
- Emphasize security risks (e.g., token leakage, expiration).
- Explain how roles/authorities can also be embedded in the token

***** Refresh Token ******
*A refresh token is a long-lived token that allows a user to obtain a new access token after the current one expires. 
*When a user logs in, we issue both an access token (short-lived) and a refresh token (long-lived).
The access token is used for calling protected APIs. When it expires, the client sends the refresh token to a special endpoint like /auth/refresh.
If the refresh token is valid, we issue a new access token — without forcing the user to log in again.
This improves security by keeping access tokens short-lived and allows us to handle token renewal smoothly.
 */
public class JWTAuthFilter extends OncePerRequestFilter {

	@Autowired
	private JWTUtil jwtUtil;

	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
			FilterChain filterChain) throws ServletException, IOException {

		final String authHeader = request.getHeader("Authorization");
		String jwt = null;
		String username = null;

		if (authHeader != null && authHeader.startsWith("Bearer ")) {
			jwt = authHeader.substring(7);
			username = jwtUtil.extractUsername(jwt);
		}

		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetails = userDetailsService.loadUserByUsername(username);
			if (jwtUtil.validateToken(jwt, userDetails)) {
				UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
				SecurityContextHolder.getContext().setAuthentication(authToken);
			}
		}

		filterChain.doFilter(request, response);
	}
}
