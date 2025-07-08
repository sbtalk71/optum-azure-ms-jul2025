package com.demo.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;

import com.demo.spring.observability.MethodCallTrackerHandler;

import io.micrometer.observation.ObservationRegistry;
import io.micrometer.observation.aop.ObservedAspect;

@SpringBootApplication
@EnableDiscoveryClient
public class HrServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrServiceApplication.class, args);
	}

	@Bean
	@LoadBalanced
	RestClient.Builder restClient() {
		return RestClient.builder();
	}
	
	@Bean
	ObservedAspect observedAspect(ObservationRegistry registry) {
		registry.observationConfig().observationHandler(new MethodCallTrackerHandler());
		return new ObservedAspect(registry);
	}
}
