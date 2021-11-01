/**
 * 
 */
package com.java.example.demo;

import java.io.File;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.java.example.demo.entity.Student;

/**
 * @author 15197
 *
 */
public class ReadStudentDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// create session factory
		/*SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();*/
		//SessionFactory factory = new Configuration().configure().buildSessionFactory();
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try	{
			// now use the session object to save/retrieve Java objects
			// create a student object
			Student tempStudent = new Student("Madhukar", "Mani","madhuman1@gmail.com");
			
			// start transaction
			session.beginTransaction();
			
			// save the student
			session.save(tempStudent);
			
			// commit the transaction
			session.getTransaction().commit();
			
			// MY NEW CODE
			
			// find out the student's id: primary key
			System.out.println("Saved student. Generated id: " + tempStudent.getId());
			
			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student based on the id: primary key
			System.out.println("\nGetting student with id: " + tempStudent.getId());
			
			Student myStudent = session.get(Student.class, tempStudent.getId());
			
			System.out.println("Get complete: " + myStudent);
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}	finally	{
			factory.close();
		}

	}

}
