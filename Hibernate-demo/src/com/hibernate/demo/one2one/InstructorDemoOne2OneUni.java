package com.hibernate.demo.one2one;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import com.hibernate.demo.entity.Student;

public class InstructorDemoOne2OneUni {

	public static void main(String[] args) {
		
		//createInstructor();
		createInstructorBi();
		//getInstructor();
		//deleteInstructor(); // also remove the assosiated object instructorDetail.getInstructor().setInstructorDetail(null);
	}

	private static void createInstructorBi() {
		
		SessionFactory factory = new Configuration()
								.configure()
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();

		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			
			int id = 101;
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);
			
			System.out.println(instructorDetail);
			
			System.out.println(instructorDetail.getInstructor());
			
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

	private static void createInstructor() {
		
		SessionFactory factory = new Configuration()
								.configure()
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {		
			Instructor instructor = new Instructor("Ram", "Das", "ram.das@demo.com");
			InstructorDetail instructorDetail = new InstructorDetail("youtube.com/ramDsinger", "Singing");
			instructor.setInstructorDetail(instructorDetail);
			session.beginTransaction();
			session.save(instructor); // also save instructor details bcuz of cascade
			session.getTransaction().commit();
			System.out.println(instructor);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			factory.close();
		}
		
	}

}
