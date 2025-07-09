package com.demo.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.csrf(csrf -> csrf.disable());
		http.authorizeHttpRequests(auth->auth.anyRequest().authenticated());
		http.httpBasic(Customizer.withDefaults());
		return http.build();
	}
	
	@Bean
	UserDetailsService userDetailsService() {
		InMemoryUserDetailsManager userManager= new InMemoryUserDetailsManager();
		userManager.createUser(User.withUsername("shantanu").password("$2a$10$KJ5fD.A3jvoTLALJ.09hUeJZvsd.i83K2lx4XiUOrQo8kqZfaGbOS").roles("ADMIN").build());
		userManager.createUser(User.withUsername("pavan").password("$2a$10$KJ5fD.A3jvoTLALJ.09hUeJZvsd.i83K2lx4XiUOrQo8kqZfaGbOS").roles("USER").build());
		userManager.createUser(User.withUsername("rajesh").password("$2a$10$KJ5fD.A3jvoTLALJ.09hUeJZvsd.i83K2lx4XiUOrQo8kqZfaGbOS").roles("OTHER").build());
		return userManager;
	}
	
	@Bean
	BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
