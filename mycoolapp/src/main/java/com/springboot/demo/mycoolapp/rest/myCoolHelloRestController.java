package com.springboot.demo.mycoolapp.rest;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class myCoolHelloRestController {

	@GetMapping("/")
	public String sayHello() {
		return "Hello World from Spring boot "+LocalDateTime.now();
	}
	
	@GetMapping("/workout")
	public String getDailyWorkout() {
		return "Run hard 5k";
	}
}
