package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.demo.spring.jwt.util.JwtFilter;

@Configuration
@EnableWebSecurity

public class SecurityConfig {

	@Autowired
	JwtFilter jwtFilter;
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		/*
		 * http.authorizeHttpRequests(auth ->
		 * auth.requestMatchers("/emp/**").hasRole("ADMIN").requestMatchers("/hr/**")
		 * .hasRole("USER").anyRequest().permitAll());
		 */
		http.authorizeHttpRequests(auth -> auth.requestMatchers("/authenticate").permitAll().anyRequest().authenticated());
		//http.httpBasic(Customizer.withDefaults());
		http.csrf(csrf -> csrf.disable());
		http.exceptionHandling(Customizer.withDefaults()).sessionManagement(sess->sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

		return http.build();
	}

	
	
	@Bean
	BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception{
		return authConfig.getAuthenticationManager();
	}
}
