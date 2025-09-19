package com.org.config;

import org.springframework.scheduling.annotation.Async;

public class ServiceClassUtilizeAsync {

	public Object processNotification() {

		return null;
	}

	@Async("asyncTaskExecutor")
	public void assignVendor() {

	}

}
