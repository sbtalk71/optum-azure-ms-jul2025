package com.demo.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo.spring.observabilty.MethodCallTrackerHandler;

import io.micrometer.observation.ObservationRegistry;
import io.micrometer.observation.aop.ObservedAspect;

@SpringBootApplication

public class EmpServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpServiceApplication.class, args);

	}

	//@Bean
	ObservedAspect observedAspect(ObservationRegistry registry) {
		registry.observationConfig().observationHandler(new MethodCallTrackerHandler());
		return new ObservedAspect(registry);
	}
}
