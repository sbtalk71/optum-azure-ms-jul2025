package com.demo.spring.services;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.demo.spring.dto.EmpDTO;

@Service
public class HrService {

	private RestClient restClient;

	public HrService(RestClient restClient) {
		this.restClient = restClient;
	}

	
	public EmpDTO getDetails(Integer id) {
		return this.restClient.get().uri("http://localhost:8080/emp/" + id).accept(MediaType.APPLICATION_JSON)
				.retrieve().body(EmpDTO.class);
	}
}
