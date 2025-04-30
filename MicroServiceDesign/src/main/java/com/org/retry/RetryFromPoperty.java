package com.org.retry;

import java.sql.SQLException;

import org.springframework.context.annotation.PropertySource;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;

@PropertySource("classpath:retryConfig.properties")
class AppConfig1 {
}

public class RetryFromPoperty {

	@Retryable(retryFor=SQLException.class,maxAttempts = ="${retry.maxAttempts}" , 
			backoff=@Backoff (delayExpression="${retry.maxDelay}"))
	void retryServiceWithExternalConfiguration(String sql) throws SQLException;

	{
	}

// printing retry count by below method

@Override
public void retryService() {
    logger.info("Retry Number: "+ RetrySynchronizationManager.getContext().getRetryCount());
    logger.info("throw RuntimeException in method retryService()");
    throw new RuntimeException();
}
