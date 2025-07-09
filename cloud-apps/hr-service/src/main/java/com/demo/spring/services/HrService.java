package com.demo.spring.services;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClient.Builder;

import com.demo.spring.feign.client.EmpClient;
import com.demo.spring.util.ResponseMessage;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.micrometer.observation.annotation.Observed;

@Service
public class HrService {

	
	private RestClient.Builder clientBuilder;

	public HrService(Builder clientBuilder, EmpClient empClient) {
		this.clientBuilder = clientBuilder;
		
	}

	
	@Observed(name="hr.emp.details")
	@CircuitBreaker(name = "emp-service-backend", fallbackMethod = "fallbackGetEmpDetails")
	public String getEmpDetails(int id) {
		return clientBuilder.build().get().uri("http://emp-service/emp/" + id).accept(MediaType.APPLICATION_JSON)
				.retrieve().body(String.class);
	}

	public String fallbackGetEmpDetails(Throwable t) {
		return t.getMessage();
	}
}
