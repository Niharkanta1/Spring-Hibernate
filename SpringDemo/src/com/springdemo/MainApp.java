package com.springdemo;

public class MainApp {
	
	public static void main(String[] args) {
		
		Coach theCoach = new TrackCoach();
		System.out.println(theCoach.getDailyWorkout());
		
	}
}
