package com.hibernate.demo;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class CreateStudentDemo {
	
	//public static Logger logger = LogManager.getLogManager().get;
	
	public static void main(String[] args) {
		
		//insertStudent();
		//getStudent();
		updateStudent();
		
	}
	
	private static void updateStudent() {
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			Student student = session.get(Student.class, 3);
			student.setFirstName("Suresh");
			student.setEmail("suresh.paul@demo.com");
			session.getTransaction().commit();
			System.out.println(student);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			factory.close();
		}
	}

	private static void getStudent() {
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			List<Student> students = session.createQuery("from Student", Student.class).getResultList();
			
			displayStudents(students);
			List<Student> students2 = session.createQuery("from Student where last_name like '%th%'", Student.class).getResultList();
			displayStudents(students2);
			
			session.getTransaction().commit();
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> students) {
		for(Student std : students) {
			System.out.println(std);
		}
	}
	private static void insertStudent() {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			Student std = new Student("Nihar", "Tripathy", "nihar.tripathy@demo.com");
				//	std2 = new Student("Rahul", "Sen", "rahul.sen@demo.com");
			session.beginTransaction();
			session.save(std);
			//session.save(std2);
			session.getTransaction().commit();
			
			System.out.println("Transaction complete....with Student id "+std.getId());
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			factory.close();
		}
		
	}

}
