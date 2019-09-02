package com.springdemo.annotation;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements NewCoach {
	
	@Value("${foo.email}")
	private String email;
	
	@Value("${foo.team}")
	private String team;
	
	private SelectionService selectionService;

	public SwimCoach(SelectionService selectionService) {
		super();
		this.selectionService = selectionService;
	}

	@Override
	public String getDailyWorkout() {
		
		return "Practice butterfly for 30 minutes.";
	}

	@Override
	public String getSelectionStatus() {
		
		return "for swimming = " +selectionService.getSelectionStatus();
	}
	
	public String getDetails() {
		return "Email : "+ email +"and Team: "+ team;
	}

}
