package com.springdemo.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements NewCoach {
	
	SelectionService selectionService;
	
	public FootballCoach() {
		System.out.println(">> Default constructor: FootballCoach");
	}
	
	public SelectionService getSelectionService() {
		return selectionService;
	}

	@Autowired
	@Qualifier("mySelectionService")
	public void setSelectionService(SelectionService selectionService) {
		System.out.println(">> setter method: FootballCoach");
		this.selectionService = selectionService;
	}

	@Override
	public String getDailyWorkout() {
	
		return "Pactice dribble for 15 minutes.";
	}

	@Override
	public String getSelectionStatus() {
		return selectionService.getSelectionStatus();
	}

}
