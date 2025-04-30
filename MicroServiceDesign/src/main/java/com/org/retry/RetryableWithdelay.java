package com.org.retry;

import java.sql.SQLException;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public interface RetryableWithdelay {
	/*
	 * In order to customize a retry’s behavior, we can use the parameters
	 * maxAttempts and backoff: There will be up to two attempts and a delay of 100
	 * milliseconds.
	 */

	@Retryable(retryFor = SQLException.class, maxAttempts = 2, backoff = @Backoff(delay = 100))
	void retryServiceWithCustomization(String sql) throws SQLException;
}