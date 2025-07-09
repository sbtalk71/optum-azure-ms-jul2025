package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.function.Supplier;

@SpringBootApplication
@RestController
public class EventProducerApp {

	@Autowired
	StreamBridge streamBridge;
	public static void main(String[] args) {
		SpringApplication.run(EventProducerApp.class, args);
	}


//@Bean
	public Supplier<Event> produceEvent(){
	return ()->new Event("Shantanu","Good Morning");
}

@GetMapping("/publish")
public String sendMessage(){
		Event event=new Event(UUID.randomUUID().toString(),"Hello There");
		streamBridge.send("produceEvent-out-0",event);
		return "event sent";
}
}
