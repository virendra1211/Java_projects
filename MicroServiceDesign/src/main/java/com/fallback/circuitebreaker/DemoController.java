package com.fallback.circuitebreaker;

import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/api")
public class DemoController {

    @GetMapping("/data")
    @CircuitBreaker(name = "myCircuitBreaker", fallbackMethod = "fallbackData")
    public String getData() {
	// Simulate call to external service
	if (new Random().nextInt(10) < 7) { // simulate failure 70% of the time
	    throw new RuntimeException("Service failed!");
	}

	return "Successful Response!";
    }

    // Fallback method when exception or timeout occurs
    public String fallbackData(Throwable t) {
	return "Fallback response due to: " + t.getMessage();
    }
}
