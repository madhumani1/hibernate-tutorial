/**
 * 
 */
package com.java.example.prac;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.java.example.prac.entity.Employee;
import com.java.example.prac.utils.DateUtils;

/**
 * @author 15197
 *
 */
public class CreateEmployeePrac {

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
			// create a Employee object
			Employee tempEmployee[] = {new Employee("Madhukar", "Mani","madhumani1@gmail.com","Software Architect",165000.00,DateUtils.parseDate("02/01/1983")),
					new Employee("Priyanka", "Bhadran","prinku4u@gmail.com","Senior VP",265000.00,DateUtils.parseDate("18/06/1984")),
					new Employee("Atharvi", "Madhukar","Atharvi.Madhukar@gmail.com","CEO",865000.00,DateUtils.parseDate("19/03/2019")),
					new Employee("Satvika", "Madhukar","Satvika.Madhukar@gmail.com","MD",1000000.00,DateUtils.parseDate("03/09/2021"))};
			
			// start transaction
			session.beginTransaction();
			
			// save the Employees
			for(Employee temp : tempEmployee)
				session.save(temp);
			
			// commit the transaction
			session.getTransaction().commit();
		} catch (Exception exc) {
            exc.printStackTrace();
        }	finally	{
			factory.close();
		}

	}

}
