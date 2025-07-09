package com.demo.spring.exceptions;

public class EmployeeNotFoundException extends ResourceException {

	public EmployeeNotFoundException() {

	}

	public EmployeeNotFoundException(String message) {
		super(message);
	}
}
