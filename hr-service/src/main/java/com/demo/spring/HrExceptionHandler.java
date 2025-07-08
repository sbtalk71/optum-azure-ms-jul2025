package com.demo.spring;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.demo.spring.exceptions.HrResourceException;
import com.demo.spring.util.ResponseMessage;

@RestControllerAdvice
public class HrExceptionHandler {

	@ExceptionHandler(HrResourceException.class)
	public ResponseEntity<ResponseMessage> handle(HrResourceException ex){
		return ResponseEntity.ok(new ResponseMessage(ex.getMessage()));
	}
}
