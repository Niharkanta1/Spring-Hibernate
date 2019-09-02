package com.springdemo.annotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("annotation-applicationContext.xml");
		NewCoach coach = context.getBean("myNewCoach", NewCoach.class);
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getSelectionStatus());
		
		// using default bean id "footballCoach" for class FootballCoach
		NewCoach fbcoach = context.getBean("footballCoach", NewCoach.class);
		System.out.println(fbcoach.getDailyWorkout());
		System.out.println(fbcoach.getSelectionStatus());
		
		// using field injection with autowired.
		HockeyCoach hockeyCoach = context.getBean("hockeyCoach", HockeyCoach.class);
		System.out.println(hockeyCoach.getDailyWorkout());
		System.out.println(hockeyCoach.getSelectionStatus());
		System.out.println(hockeyCoach.getDetails());
		
		context.close();
	}

}
