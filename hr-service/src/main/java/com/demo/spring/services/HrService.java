package com.demo.spring.services;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.demo.spring.dto.EmpDTO;
import com.demo.spring.exceptions.HrResourceException;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.micrometer.observation.annotation.Observed;

@Service
public class HrService {

	private RestClient.Builder restClientBuilder;

	public HrService(RestClient.Builder restClientBuilder) {
		this.restClientBuilder = restClientBuilder;
	}

	@CircuitBreaker(name="hr-service-cb",fallbackMethod = "getDetailsFallback")
	@Observed(name="hr.emp.details")
	public EmpDTO getDetails(Integer id) {
		System.out.println("inside getDetails.....");
		try {
		return this.restClientBuilder.build().get().uri("http://emp-service/emp/" + id).accept(MediaType.APPLICATION_JSON)
				.retrieve().body(EmpDTO.class);
		}catch (RuntimeException e) {
			System.out.println("In catch Block...");
			throw new HrResourceException(e.getMessage());
		}
	}
	
	public EmpDTO getDetailsFallback(Throwable t) {
		//throw new HrResourceException("Service unavailable....");
		return new EmpDTO(00, "Service Unavailable", "Service Unavailable", 0);
	}
}
