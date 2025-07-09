package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Consumer;

@SpringBootApplication

public class EventConsumerApp {

	public static void main(String[] args) {
		SpringApplication.run(EventConsumerApp.class, args);
	}


	@Bean
	public Consumer<Event> consumeEvent(){
		return event-> System.out.println(event.getName()+" "+event.getMessage());
	}
}
