package com.cg.mypaymentsapp.exception;

public class InvalidInputException extends Exception {

	public InvalidInputException(String msg) {
		super(msg);
	}

	public InvalidInputException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InvalidInputException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public InvalidInputException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidInputException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
