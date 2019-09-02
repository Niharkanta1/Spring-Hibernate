package org.springBootDemo;


import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;

@RestController
@SpringBootApplication
@EnableAutoConfiguration
public class SpringBootWebApplication {
	
	@RequestMapping("/")
	String home() {
		return "Hello World!";
	}
	
    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebApplication.class, args);
    }
}