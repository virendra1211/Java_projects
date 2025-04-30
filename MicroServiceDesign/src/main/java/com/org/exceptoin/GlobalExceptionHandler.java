package com.org.exceptoin;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler({ ArithmeticException.class, NullPointerException.class,
			IllegalArgumentException.class })
	public ResponseEntity<Object> handleGlobalException(Exception exception) {

		CustomError error = new CustomError();

		error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		if (exception instanceof ArithmeticException) {
			error.setMsg("Arithmetic error occurred: " + exception.getLocalizedMessage());
		} else if (exception instanceof NullPointerException) {
			error.setMsg("Null pointer exception occurred: " + exception.getLocalizedMessage());
		} else if (exception instanceof IllegalArgumentException) {
			error.setMsg("Illegal argument: " + exception.getLocalizedMessage());
		} else {
			error.setMsg("Unexpected exception: " + exception.getLocalizedMessage());
		}

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
	}

}

class CustomError {

	public void setErrorCode(int value) {
		// TODO Auto-generated method stub

	}

	public void setMsg(String string) {
		// TODO Auto-generated method stub

	}

}