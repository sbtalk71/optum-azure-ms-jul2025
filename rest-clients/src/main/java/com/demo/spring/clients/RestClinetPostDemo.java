package com.demo.spring.clients;


import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;

public class RestClinetPostDemo {

	public static void main(String[] args) {
		RestClient restClient= RestClient.create();
		
		EmpDTO dto=new EmpDTO(116, "Ankita", "Noida", 57000);
		
	EmpDTO resp =	 restClient.post()
					.uri("http://localhost:8080/emp")
					.body(dto)
					.accept(MediaType.APPLICATION_JSON)
					.contentType(MediaType.APPLICATION_JSON)
					.retrieve()
					.body(EmpDTO.class);
	System.out.println(resp);

	}

}
