package com.springdemo;

public class BaseballCoach implements Coach {

	private FortuneService fortuneService;
	
	public BaseballCoach(FortuneService thefortuneService) {
		fortuneService = thefortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Spend 30 minutes in batting practice.";	
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
