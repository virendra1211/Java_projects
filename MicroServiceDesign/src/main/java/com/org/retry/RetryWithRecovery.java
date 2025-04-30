package com.org.retry;

import java.sql.SQLException;

import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public interface RetryWithRecovery {
	/*
	 * @Recovery annotation defined a separate recovery method when a @Retryable
	 * method fails with a specified exception
	 */
	@Retryable(retryFor = SQLException.class)
	void retryServiceWithRecovery(String sql) throws SQLException;

	@Recover
	void recover(SQLException e, String sql);
}