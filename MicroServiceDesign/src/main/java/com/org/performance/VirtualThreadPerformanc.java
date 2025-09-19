package com.org.performance;

import java.util.concurrent.Executor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class VirtualThreadPerformanc {

	private Executor virtualThreadExecutor;

	public void generatedReportForRegion(String region) {
		virutalThreadExecutor.execute(() ->{
			List<Stock> stock = reposisotry.findByRegion(region); // 1
			try {
			}
			}
		});
}

}

@Configuration
class VirtualThreadExecutorConfig {

	@Bean(name = "virtualThreadExecutor")
	public Executor virtualThreadExecutor() {
		// return Executors.newVirtualThreadPerTaskExecutor(); // as it's work on only
		// java 24
		return null;
	}
}