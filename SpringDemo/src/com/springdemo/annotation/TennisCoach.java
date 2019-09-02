package com.springdemo.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("myNewCoach")
public class TennisCoach implements NewCoach {
	
	SelectionService selectionService;
	
	@Autowired
	public TennisCoach(@Qualifier("mySelectionService") SelectionService selectionService) {
		this.selectionService = selectionService;
	}

	@Override
	public String getDailyWorkout() {
		
		return "Practice your backhand volley.";
	}

	@Override
	public String getSelectionStatus() {
		return selectionService.getSelectionStatus();
	}

}
