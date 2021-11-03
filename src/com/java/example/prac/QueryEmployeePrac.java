/**
 * 
 */
package com.java.example.prac;

import java.util.List;
import java.io.File;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.java.example.prac.entity.Employee;

/**
 * @author 15197
 *
 */
public class QueryEmployeePrac {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// create session factory
		/*SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Employee.class)
									.buildSessionFactory();*/
		//SessionFactory factory = new Configuration().configure().buildSessionFactory();
		SessionFactory factory = new Configuration()
								.configure("emp.hibernate.cfg.xml").addAnnotatedClass(Employee.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try	{
			// start a transaction
			session.beginTransaction();
						
			// query employees
			List<Employee> theEmployees = session.createQuery("from Employee").list();
			
			// display the employees
			displayEmployees(theEmployees);
			
			// query employees: lastName='Doe'
			theEmployees = session.createQuery("from Employee s where s.lastName='Doe'").list();
			
			// display the employees
			System.out.println("\n\nEmployees who have last name of Madhukar");
			displayEmployees(theEmployees);
			
			// query employees: lastName='Doe' OR firstName='Daffy'
			theEmployees =
					session.createQuery("from Employee s where"
							+ " s.firstName='Madhukar' ").list();
			
			System.out.println("\n\nEmployees who have last name of Madhukar");
			displayEmployees(theEmployees);
			
			// query employees where email LIKE '%gmail.com'
			theEmployees = session.createQuery("from Employee s where"
					+ " s.email LIKE '%gmail.com'").list();

			System.out.println("\n\nEmployees whose email ends with gmail.com");			
			displayEmployees(theEmployees);
			
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}	finally	{
			factory.close();
		}

	}
	
	private static void displayEmployees(List<Employee> theEmployees) {
		for (Employee tempEmployee : theEmployees) {
			System.out.println(tempEmployee);
		}
	}

}
