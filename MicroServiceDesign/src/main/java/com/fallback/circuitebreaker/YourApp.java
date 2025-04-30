package com.fallback.circuitebreaker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@EnableCircuitBreaker
@SpringBootApplication
public class YourApp {
	public static void main(String[] args) {
		SpringApplication.run(YourApp.class, args);
	}
}
