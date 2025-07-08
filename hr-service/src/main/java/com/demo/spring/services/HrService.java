package com.demo.spring.services;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.demo.spring.dto.EmpDTO;
import com.demo.spring.exceptions.HrResourceException;

@Service
public class HrService {

	private RestClient.Builder restClientBuilder;

	public HrService(RestClient.Builder restClientBuilder) {
		this.restClientBuilder = restClientBuilder;
	}

	
	public EmpDTO getDetails(Integer id) {
		try {
		return this.restClientBuilder.build().get().uri("http://emp-service/emp/" + id).accept(MediaType.APPLICATION_JSON)
				.retrieve().body(EmpDTO.class);
		}catch (RuntimeException e) {
			throw new HrResourceException(e.getMessage());
		}
	}
}
