package com.myInstitute.myERPSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.RedirectViewControllerRegistration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@RestController
@SpringBootApplication
@ComponentScan("com.myInstitute.myERPSystem")
public class MyErpSystemApplication {
	public static void main(String[] args) {
		SpringApplication.run(MyErpSystemApplication.class, args);
	}
	
}
