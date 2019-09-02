package com.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Coach theCoach = context.getBean("myCoach", Coach.class);
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		
		System.out.println("\n--- Using string literals and setter dependency injection ---\n");
		
		CricketCoach theCricketCoach = context.getBean("myCricketCoach", CricketCoach.class);
		System.out.println(theCricketCoach.getDailyWorkout());
		System.out.println(theCricketCoach.getDailyFortune());
		System.out.println(theCricketCoach.getDetails());
		
		System.out.println("\n---- Using properties file ---\n");
		
		CricketCoach the2ndCricketCoach = context.getBean("my2ndCricketCoach", CricketCoach.class);
		System.out.println(the2ndCricketCoach.getDailyWorkout());
		System.out.println(the2ndCricketCoach.getDailyFortune());
		System.out.println(the2ndCricketCoach.getDetails());
		
		context.close();
	}

}



