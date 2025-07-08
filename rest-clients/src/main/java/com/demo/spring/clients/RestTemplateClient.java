package com.demo.spring.clients;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestTemplateClient {

	public static void main(String[] args) {
		
		RestTemplate rt= new RestTemplate();
		
		EmpDTO dto=new EmpDTO(115, "Arjun", "Delhi", 57000);
		
		HttpHeaders headers= new HttpHeaders();
		headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		
		HttpEntity<EmpDTO> httpReq=new HttpEntity<EmpDTO>(dto, headers);
		
	ResponseEntity<EmpDTO> response= rt.exchange("http://localhost:8080/emp", HttpMethod.POST, httpReq, EmpDTO.class);
	
	System.out.println(response.getBody());
		
		

	}

}
