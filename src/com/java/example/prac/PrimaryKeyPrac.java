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
public class PrimaryKeyPrac {

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
			// create 3 employee objects
			// now use the session object to save/retrieve Java objects
			// create a Employee object
			Employee tempEmployee[] = {new Employee("Neil", "Martis","meil.martis@gmail.com","Developer",65000.00),
					new Employee("Amandeep", "Singh","Amandeep.Singh@gmail.com","BSA",65000.00),
					new Employee("Nandkumar", "BS","Nandkumar.Nandu@gmail.com","Senior Tester",85000.00),
					new Employee("Dilip", "Dhyani","Dilip.Kumar@gmail.com","Manager",100000.00)};
			
			System.out.println("Creating 3 employee objects...");
			// start transaction
			session.beginTransaction();
			
			// save the Employees
			System.out.println("Saving the employees...");
			for(Employee temp : tempEmployee)
				session.save(temp);
			
			// commit the transaction
			session.getTransaction().commit();
				
			System.out.println("Done!");
		}	finally	{
			factory.close();
		}

	}

}
