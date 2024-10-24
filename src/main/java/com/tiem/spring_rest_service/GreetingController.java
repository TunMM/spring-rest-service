package com.tiem.spring_rest_service;

import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private static final String template= "Hello, %s!";
	
	public AtomicLong counter = new AtomicLong(); 
	
	private static final Logger log = LoggerFactory.getLogger(GreetingController.class);
	
	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(defaultValue = "World") String name) {
		log.info(name);
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
}
	