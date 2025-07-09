package com.demo.spring.exceptions;

public class ResourceException extends RuntimeException {

	public ResourceException() {

	}

	public ResourceException(String message) {
		super(message);
	}
}
