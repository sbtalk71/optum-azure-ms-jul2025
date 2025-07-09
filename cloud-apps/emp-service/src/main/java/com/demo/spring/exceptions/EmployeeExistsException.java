package com.demo.spring.exceptions;

public class EmployeeExistsException extends ResourceException {

	public EmployeeExistsException() {

	}

	public EmployeeExistsException(String message) {
		super(message);
	}
}
