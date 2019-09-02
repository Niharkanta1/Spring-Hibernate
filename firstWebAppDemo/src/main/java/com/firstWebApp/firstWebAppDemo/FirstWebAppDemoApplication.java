package com.firstWebApp.firstWebAppDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.RedirectViewControllerRegistration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@RestController
@SpringBootApplication
@ComponentScan("com.firstWebApp.firstWebAppDemo")
public class FirstWebAppDemoApplication extends WebMvcConfigurerAdapter {
	
	public void addViewControllers (ViewControllerRegistry registry) {
	      RedirectViewControllerRegistration r =
	                registry.addRedirectViewController("/", "/login");
	  }
	
	public static void main(String[] args) {
		SpringApplication.run(FirstWebAppDemoApplication.class, args);
	}
}

