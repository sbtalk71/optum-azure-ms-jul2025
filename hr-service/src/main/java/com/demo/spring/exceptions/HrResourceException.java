package com.demo.spring.exceptions;

public class HrResourceException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public HrResourceException() {

	}

	public HrResourceException(String message) {
		super(message);
	}
}
