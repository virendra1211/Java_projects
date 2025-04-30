package com.org.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig_good {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable()) // 1
				.authorizeHttpRequests(auth -> auth // 2
						.requestMatchers("/auth/**").permitAll() // 3
						.requestMatchers("/admin/**").hasRole("ADMIN") // 4
						.anyRequest().authenticated()// 5
				).sessionManagement(
						session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS) // 6
				).addFilterBefore(jwtAuthFilter(), UsernamePasswordAuthenticationFilter.class); // 7
		return http.build();
	}

	@Bean
	public JWTAuthFilter jwtAuthFilter() {
		return new JWTAuthFilter(); // Custom filter below
	}

	@Bean // 8
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
