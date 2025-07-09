package com.demo.spring.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class MyPasswordEncrypter {

	public static void main(String[] args) {
		BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
		System.out.println(encoder.encode("welcome1"));

	}

}
