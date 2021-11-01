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
public class PrimaryKeyDemo {

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
			// create 3 student objects
			System.out.println("Creating 3 student objects...");
			Student tempStudent1 = new Student("Neil", "Martis", "neil.martis@gmail.com");
			Student tempStudent2 = new Student("Amandeep", "Singh", "amandeep.singh@gmail.com");
			Student tempStudent3 = new Student("Nandu", "BSNK", "nandu.bsnk@gmail.com");
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("Saving the students...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}	finally	{
			factory.close();
		}

	}

}
