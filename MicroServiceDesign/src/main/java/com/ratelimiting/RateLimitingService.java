package com.ratelimiting;

import java.time.Duration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import io.github.bucket4j.*;


@Service
public class RateLimitingService {
	private final Map<String, Bucket> buckets = new ConcurrentHashMap<>();
	private final int rateLimit = 10;
	private final Duration refillPeriod = Duration.ofMinutes(1);
	
	public boolean allowRequest(String apiKey) {
        Bucket bucket = buckets.computeIfAbsent(apiKey, this::createNewBucket);
        return bucket.tryConsume(1);
    }

    private Bucket createNewBucket(String apiKey) {
        Bandwidth limit = Bandwidth.classic(rateLimit, Refill.intervally(rateLimit, refillPeriod));
        return Bucket4j.builder()
                .addLimit(limit)
                .build();
    }

}
