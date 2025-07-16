package com.ratelimiting;

import java.util.concurrent.ConcurrentHashMap;

public class RateLimiter {
	private final int maxRequests;
	private final long timeWindowMillis;

	private static class RequestInfo {
		int count;
		long startTime;

		RequestInfo(int count, long startTime) {
			this.count = count;
			this.startTime = startTime;
		}
	}

	// Thread-safe map to hold request info per key
	private final ConcurrentHashMap<String, RequestInfo> requestMap = new ConcurrentHashMap<>();

	public RateLimiter(int maxRequests, long timeWindowMinutes) {
		this.maxRequests = maxRequests;
		this.timeWindowMillis = timeWindowMinutes * 60 * 1000;
	}

	public boolean allowRequest(String key) {
		long currentTime = System.currentTimeMillis();

		RequestInfo info = requestMap.get(key);

		if (info == null || currentTime - info.startTime > timeWindowMillis) {
			// New window or first request
			RequestInfo newInfo = new RequestInfo(1, currentTime);
			requestMap.put(key, newInfo);
			return true;
		} else {
			// Existing window
			if (info.count < maxRequests) {
				info.count++;
				return true;
			} else {
				return false; // Blocked
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		RateLimiter limiter = new RateLimiter(10, 1); // 10 requests per 1 minute

		String apiKey = "client123";

		for (int i = 1; i <= 15; i++) {
			if (limiter.allowRequest(apiKey)) {
				System.out.println("Request " + i + " allowed.");
			} else {
				System.out.println("Request " + i + " blocked.");
			}

			// Simulate a delay
			Thread.sleep(500);
		}
	}
}
