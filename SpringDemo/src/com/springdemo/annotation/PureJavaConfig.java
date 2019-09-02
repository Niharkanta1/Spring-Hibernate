package com.springdemo.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:sport.properties") // Loading properties files.
public class PureJavaConfig {
	
	@Bean
	public SelectionService mySelectionService() {
		return new MySelectionService();
	}
	
	@Bean
	public NewCoach swimCoach() {
		return new SwimCoach(mySelectionService());
	}
}
