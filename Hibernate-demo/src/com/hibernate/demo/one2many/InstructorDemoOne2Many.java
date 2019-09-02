package com.hibernate.demo.one2many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;

public class InstructorDemoOne2Many {

	public static void main(String[] args) {

		//createInstructorCourse();
		getInstructorCourses();
		//deleteInstructorCourse();

	}

	private static void deleteInstructorCourse() {
		SessionFactory factory = new Configuration()
								.configure()
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		try {
			
			session.beginTransaction();
			
			int id = 202;
			
			Course tmpCourse = session.get(Course.class, id);
			
			session.delete(tmpCourse);
			
			session.getTransaction().commit();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			System.out.println("Closing factory....");
			session.close(); // leaking issue
			factory.close();
		}
		
	}

	private static void getInstructorCourses() {
		SessionFactory factory = new Configuration()
								.configure()
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		

		Session session = factory.getCurrentSession();
		try {
			
			session.beginTransaction();
			
			int instId = 1004;
			
			Instructor tmpInstructor = session.get(Instructor.class, instId);
			System.out.println(tmpInstructor);
			System.out.println("Courses: " + tmpInstructor.getCourses());

			session.getTransaction().commit();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			System.out.println("Closing factory....");
			session.close(); // leaking issue
			factory.close();
		}
	}

	private static void createInstructorCourse() {

		SessionFactory factory = new Configuration()
								.configure()
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();

		Session session = factory.getCurrentSession();
		try {
			
			session.beginTransaction();
			
			Instructor instructor = new Instructor("Susan", "Publicana", "susan@demo.com");
			InstructorDetail instructorDetail = new InstructorDetail("youtube.com/susanGamer", "Vedeo Gaming");
			instructor.setInstructorDetail(instructorDetail);	
			
			session.save(instructor);
			
			Course course1 = new Course("Air Guitar - Ultimate Guide");
			Course course2 = new Course("The Pinball Masters");
						
			instructor.add(course1);
			instructor.add(course2);
			
			session.save(course1);
			session.save(course2);
			
			session.getTransaction().commit();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			System.out.println("Closing factory....");
			session.close(); // leaking issue
			factory.close();
		}
		
	}

}
