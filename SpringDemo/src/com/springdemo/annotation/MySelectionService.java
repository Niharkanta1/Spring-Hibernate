package com.springdemo.annotation;

import org.springframework.stereotype.Component;

@Component
public class MySelectionService implements SelectionService{

	@Override
	public String getSelectionStatus() {
		
		return "You are selected.";
	}

}
