package com.springdemo.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PureJavaConfigDemoApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PureJavaConfig.class);
		System.out.println("Annotation Configuration using Pure Java code is successful");
		
		//NewCoach coach = context.getBean("swimCoach", NewCoach.class);
		SwimCoach coach = context.getBean("swimCoach", SwimCoach.class);
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getSelectionStatus());
		System.out.println(coach.getDetails());
		
		context.close();
	}

}
