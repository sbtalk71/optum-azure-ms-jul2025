package com.demo.spring.clients;

import org.springframework.web.client.RestTemplate;

public class RestTemplatePostClient {

	public static void main(String[] args) {
		
		RestTemplate rt= new RestTemplate();
		String response=rt.getForObject("http://localhost:8080/emp/104", String.class);
		System.out.println(response);
		
		EmpDTO empResp=rt.getForObject("http://localhost:8080/emp/104", EmpDTO.class);
		
		System.out.println(empResp);

	}

}
