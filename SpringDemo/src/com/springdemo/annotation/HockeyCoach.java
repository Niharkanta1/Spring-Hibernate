package com.springdemo.annotation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class HockeyCoach implements NewCoach {
	
	@Autowired
	@Qualifier("randomSelectionService")
	SelectionService selectionService;
	
	@Value("${foo.email}")
	private String email;
	
	@Value("${foo.hokeyteam}")
	private String team;

	@Override
	public String getDailyWorkout() {
		return "Practice penalty shootout for 30 minutes";
	}

	@Override
	public String getSelectionStatus() {
		return selectionService.getSelectionStatus();
	}

	public String getDetails() {
		return "HockeyCoach [email=" + email + ", team=" + team + "]";
	}
	
	@PostConstruct
	public void initMethodforBean() {
		System.out.println("similar to init-method property in xml");
	}
	
	@PreDestroy
	public void destroyMethodforBean() {
		System.out.println("similar to destroy-method property in xml");
	}
}
