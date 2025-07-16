package com.ratelimiting;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class RateLimitFilter implements Filter {

	@Autowired
	private RateLimitingService rateLimitingService;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		String apiKey = httpRequest.getHeader("X-API-Key"); // Example using API Key

		if (apiKey == null || apiKey.isEmpty()) {
			httpResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
			httpResponse.getWriter().write("API Key is missing");
			return;
		}

		if (!rateLimitingService.allowRequest(apiKey)) {
			httpResponse.setStatus(HttpStatus.TOO_MANY_REQUESTS.value());
			httpResponse.getWriter().write("Too Many Requests");
			return;
		}

		chain.doFilter(request, response);
	}
}