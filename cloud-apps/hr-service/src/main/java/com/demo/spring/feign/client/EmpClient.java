package com.demo.spring.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="emp-service",path="/emp")
public interface EmpClient {

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<String> getempList();
}
