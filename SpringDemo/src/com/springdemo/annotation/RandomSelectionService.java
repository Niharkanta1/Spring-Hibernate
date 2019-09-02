package com.springdemo.annotation;

import org.springframework.stereotype.Component;

@Component
public class RandomSelectionService implements SelectionService {

	@Override
	public String getSelectionStatus() {
		return "You are not selected today.";
	}

}
