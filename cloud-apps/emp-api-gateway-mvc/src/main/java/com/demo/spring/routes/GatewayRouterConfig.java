package com.demo.spring.routes;

import static org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions.route;
import static org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions.http;
import static org.springframework.cloud.gateway.server.mvc.filter.CircuitBreakerFilterFunctions.circuitBreaker;
import static org.springframework.cloud.gateway.server.mvc.filter.LoadBalancerFilterFunctions.lb;
import static org.springframework.cloud.gateway.server.mvc.predicate.GatewayRequestPredicates.path;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

@Configuration
public class GatewayRouterConfig {
 
	
	@Bean
	public RouterFunction<ServerResponse> getHrServicePath(){
		return route("hr-backend").route(path("/hr/**"),http()).filter(lb("hr-service"))
				.filter(circuitBreaker(config->config.setId("hr-backend").setFallbackPath("/error-message"))).build();
	}
	
	@Bean
	public RouterFunction<ServerResponse> getEmpServicePath(){
		return route("emp-backend").route(path("/emp/**"),http()).filter(lb("emp-service"))
				.filter(circuitBreaker(config->config.setId("hr-backend").setFallbackPath("/error-message"))).build();
	}
	
	/*
	 * @Bean public RouterFunction<ServerResponse> getTestPath(){ return
	 * route("test").route(path("/tes/**"),http()).uri()
	 * .filter(circuitBreaker(config->config.setId("hr-backend").setFallbackPath(
	 * "/error-message"))).build(); }
	 */
	
}
