package com.org.retry;

import org.jvnet.hk2.annotations.Service;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.annotation.Retryable;

@Configuration
@EnableRetry
public class AppConfigRetry {

}

@Service
interface MyService {
	/*
	 * @Retryable‘s default behavior, the retry may happen up to three times, with a
	 * delay of one second between retries.
	 */
	@Retryable
	void retryService(String sql);
}
