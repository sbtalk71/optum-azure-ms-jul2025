package com.demo.spring.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.demo.spring.util.ResponseMessage;

@RestControllerAdvice
public class EmpExceptionHandler {

	@ExceptionHandler(EmpResourceException.class)
	public ResponseEntity<ResponseMessage> handle(EmpResourceException e){
		return ResponseEntity.ok(new ResponseMessage(e.getMessage()));
	}
}
