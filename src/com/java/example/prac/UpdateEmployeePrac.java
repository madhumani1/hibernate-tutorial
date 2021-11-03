/**
 * 
 */
package com.java.example.prac;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.java.example.prac.entity.Employee;

/**
 * @author 15197
 *
 */
public class UpdateEmployeePrac {

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
			int employeeId = 1;
			
			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve employee based on the id: primary key
			System.out.println("\nGetting employee with id: " + employeeId);
			
			Employee myEmployee = session.get(Employee.class, employeeId);
			
			System.out.println("Updating employee...");
			myEmployee.setEmail("Madhukar.Mani@gmail.com");
			
			// commit the transaction
			session.getTransaction().commit();

			// NEW CODE
			employeeId = 2;
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// update email for all employees
			System.out.println("Update email for all employees");
			
			session.createQuery("update Employee set email='Priyankab.Madhukar@gmail.com' where id="+employeeId)
				.executeUpdate();
						
			// commit the transaction
			session.getTransaction().commit();

			
			System.out.println("Done!");
		}	finally	{
			factory.close();
		}

	}

}
