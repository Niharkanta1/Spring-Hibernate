package com.hibernate.demo.one2many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import com.hibernate.demo.entity.Review;

public class InstructorDemoOne2ManyUni {

	public static void main(String[] args) {
		//createInstructorCourseAndReview();
		getInstructorCourseAndReview();
		//deleteInstructorCourseAndReview();

	}

	private static void getInstructorCourseAndReview() {
		SessionFactory factory = new Configuration()
				.configure()
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		try {

				session.beginTransaction();
				
				int courseId = 204;
				Course tempCourse = session.get(Course.class, courseId);
				System.out.println(tempCourse);
				
				System.out.println(tempCourse.getReviews());
				
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

	private static void createInstructorCourseAndReview() {
		SessionFactory factory = new Configuration()
				.configure()
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		try {

				session.beginTransaction();
				Course tempCourse = new Course("Pacman - Beginner's Guide");
				
				tempCourse.addReview(new Review("Great Course .. loved it"));
				tempCourse.addReview(new Review("Cool .. Job well done"));
				tempCourse.addReview(new Review("What is this.. very bad course."));
				
				session.save(tempCourse);

				session.getTransaction().commit();
				
				System.out.println(tempCourse);
				
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
