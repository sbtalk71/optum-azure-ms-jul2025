package com.demo.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@Bean
	UserDetailsService userDetailsService() {
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(User.withUsername("shantanu")
				.password("$2a$10$Pe1eXL7Mad3zBjp2TNiiPOVTCvRGSlWVH/hBXvj9BttcabDE/1NH2").roles("ADMIN").build());
		manager.createUser(User.withUsername("pavan")
				.password("$2a$10$Pe1eXL7Mad3zBjp2TNiiPOVTCvRGSlWVH/hBXvj9BttcabDE/1NH2").roles("USER").build());
		manager.createUser(User.withUsername("ranga")
				.password("$2a$10$Pe1eXL7Mad3zBjp2TNiiPOVTCvRGSlWVH/hBXvj9BttcabDE/1NH2").roles("OTHER").build());
		return manager;
	}
}
