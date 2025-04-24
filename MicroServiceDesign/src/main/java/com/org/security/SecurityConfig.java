package com.org.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // Details omitted for brevity

    @Override
    protected void configure(HttpSecurity http) throws Exception {
	// Enable CORS and disable CSRF
	http = http.cors().and().csrf().disable();

	// Set session management to stateless
	http = http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and();

	// Set unauthorized requests exception handler
	http = http.exceptionHandling().authenticationEntryPoint((request, response, ex) -> {
	    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, ex.getMessage());
	}).and();

	// Set permissions on endpoints
	http.authorizeRequests()
		// Our public endpoints
		.antMatchers("/api/public/**").permitAll().antMatchers(HttpMethod.GET, "/api/author/**").permitAll()
		.antMatchers(HttpMethod.POST, "/api/author/search").permitAll()
		.antMatchers(HttpMethod.GET, "/api/book/**").permitAll()
		.antMatchers(HttpMethod.POST, "/api/book/search").permitAll()
		// Our private endpoints
		.antMatchers("/api/admin/user/**").hasRole(Role.USER_ADMIN).antMatchers("/api/author/**")
		.hasRole(Role.AUTHOR_ADMIN).antMatchers("/api/book/**").hasRole(Role.BOOK_ADMIN).anyRequest()
		.authenticated();

	// Add JWT token filter
	http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
    }

    // Details omitted for brevity

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity htttpSecurity) {
	htttpSecurity
		.csrf(AbstractHttpConfigurer::disable).authorizeHttpRequests(auth -> auth.requestMatchers("/register")
			.permitAll().requestMatchers("/login").permitAll().anyRequest().authenticated())
		.httpBasic(Customizer.withDefaults()).build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
	DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
	provider.setUserDetailsPasswordService(userDetailsService);
	provider.setPasswordEncoder(bcrypoprovider));
	return provider;
    }
}