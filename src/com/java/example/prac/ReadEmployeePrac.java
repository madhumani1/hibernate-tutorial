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
public class ReadEmployeePrac {

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
			// now use the session object to save/retrieve Java objects
			// create a employee object
			/*Employee tempEmployee = new Employee("Bittu", "Rawat","Bittu.Rawat@gmail.com","Director",300000.00);
			
			// start transaction
			session.beginTransaction();
			
			// save the employee
			session.save(tempEmployee);
			
			// commit the transaction
			session.getTransaction().commit();
			
			// MY NEW CODE
			
			// find out the employee's id: primary key
			System.out.println("Saved employee. Generated id: " + tempEmployee.getId());*/
			
			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve employee based on the id: primary key
			System.out.println("\nGetting employee with id: " + /*tempEmployee.getId()*/ 2);
			
			Employee myEmployee = session.get(Employee.class, /*tempEmployee.getId()*/ 2);
			
			System.out.println("Get complete: " + myEmployee);
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}	finally	{
			factory.close();
		}

	}

}
