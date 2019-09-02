package com.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CustomCodeConstraintValidator implements ConstraintValidator<CustomCode, String> {

	private String customPrefix;
	
	@Override
	public void initialize(CustomCode customCode) {
		customPrefix = customCode.value();
	}
	
	@Override
	public boolean isValid(String theCode, ConstraintValidatorContext constraintValidatorContext) {	
		boolean result;
		if(theCode != null)
			result = theCode.startsWith(customPrefix);
		else
			result = true;
		
		return result;
	}

}
