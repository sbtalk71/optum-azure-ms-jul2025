package com.demo.spring.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.demo.spring.util.ResponseMessage;

@RestControllerAdvice
public class EmployeeExceptionHandler {

	@ExceptionHandler(ResourceException.class)
	public ResponseEntity<ResponseMessage> handleException(ResourceException ex) {
		return ResponseEntity.ok(new ResponseMessage(ex.getMessage()));
	}
}
