package com.hibernate.demo.many2many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import com.hibernate.demo.entity.Review;
import com.hibernate.demo.entity.Student;

public class CourseAndStudentsDemoMany2Many {

	public static void main(String[] args) {
		//createCourseAndStudents();
		createCourseForMary();

	}

	private static void createCourseForMary() {
		SessionFactory factory = new Configuration()
				.configure()
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		try {

				session.beginTransaction();
				
				Student std1 = new Student("Mary", "Republic", "mary@demo.com");
				
				session.save(std1);
				System.out.println(std1+" Course: "+ std1.getCourses());
				
				Course course1 = new Course("How to Rubic's Cube");
				Course course2 = new Course("Atari 2600 - Game development");
				
				std1.addCourse(course1);
				std1.addCourse(course2);
				
				System.out.println("Saving courses");
				
				session.save(course1);
				session.save(course2);
				
				session.getTransaction().commit();
				
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			System.out.println("Closing session and factory....");
			session.close(); // leaking issue
			factory.close();
		}
		
	}

	private static void createCourseAndStudents() {
		SessionFactory factory = new Configuration()
				.configure()
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		try {

				session.beginTransaction();
				
				Course course = new Course("Be a King of Bollywood");
				System.out.println("Saving the course....");
				session.save(course);
				
				Student std1 = new Student("John", "Abrahim", "john@demo.com");
				Student std2 = new Student("Amir", "Khan", "amir@demo.com");
				
				course.addStudent(std1);
				course.addStudent(std2);
				
				System.out.println("Saving the students....");
				session.save(std1);
				session.save(std2);
				
				session.getTransaction().commit();
				
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			System.out.println("Closing session and factory....");
			session.close(); // leaking issue
			factory.close();
		}
		
	}

}
