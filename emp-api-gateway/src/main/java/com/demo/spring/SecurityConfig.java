package com.demo.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(auth -> auth.requestMatchers("/emp/**").hasRole("ADMIN").requestMatchers("/hr/**")
				.hasRole("USER").anyRequest().permitAll());
		http.httpBasic(Customizer.withDefaults());
		http.csrf(csrf -> csrf.disable());

		return http.build();
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
	
	@Bean
	BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
