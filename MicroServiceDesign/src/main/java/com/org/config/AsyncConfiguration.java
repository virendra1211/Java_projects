package com.org.config;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class AsyncConfiguration {

	/**
	 * 1. If the task are CPU heavy, your current setup is fine(Limit thread)
	 * 
	 * @return
	 */
	@Bean("asyncTaskExecutor")
	public Executor asyncTaskExecutor() {
		ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
		taskExecutor.setCorePoolSize(4); // this thread are kept alive even when they are idle
		taskExecutor.setQueueCapacity(100); // it will maximum number of task , let's 150
		taskExecutor.setMaxPoolSize(20); // it set the maximum no. of thread , if there are so man task not
											// handle by this this
		taskExecutor.setKeepAliveSeconds(60); // reclaim idle threads
		taskExecutor.setThreadNamePrefix("Async Method");
		taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
		taskExecutor.initialize();
		return taskExecutor;

	}

// 2. if request are I/O heavy(DB, Rest calls ,file ops ) , virtual threads or a larger pool is better
	@Bean(name = "asyncTaskExecutorVirtual")
	public Executor asyncTaskExecutorVirtual() {
		// Virtual threads: one lightweight thread per task
		// virtualThread, here using java 17 , hence facing compiletime issue
		return null;
		// return Executors.newVirtualThreadPerTaskExecutor();
	}
}
/*
 * The setQueueCapacity() method in ThreadPoolTaskExecutor determines the
 * maximum number of tasks that can be queued for execution when all the cores
 * threads in the thread pool are busy. Essentially, it's a way to manage how
 * tasks are handled when there's more demand for threads than can immediately
 * be fulfilled by the existing threads in the pool.
 * 
 * The maximum pool size is the maximum number of threads the thread pool can
 * create. This is the upper limit on the number of concurrent threads.
 */
/*
 * ⚡ Even Better Options If you are on Java 21, consider
 * Executors.newVirtualThreadPerTaskExecutor() instead of ThreadPoolTaskExecutor
 * → much higher concurrency with simpler config.
 * 
 * If requests are CPU-heavy, your current setup is fine (limit threads).
 * 
 * If requests are I/O-heavy (DB, REST calls, file ops), virtual threads or a
 * larger pool is better.
 */
