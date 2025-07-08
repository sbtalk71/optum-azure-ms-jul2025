package com.demo.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class EmpApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpApiGatewayApplication.class, args);
	}

	@GetMapping("/emp-service-fallback")
	public String falbackController() {
		String message="""
				{
				"status":%s
				}
				""";
		return message.formatted("Emp service is down");
	}
}
