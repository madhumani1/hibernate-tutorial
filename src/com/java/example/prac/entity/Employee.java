/**
 * 
 */
package com.java.example.prac.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.java.example.prac.utils.DateUtils;

/**
 * @author 15197
 * POJO to map Object with Relational Model. That is Class or Entity to database table
 */
@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	@Column(name="designation")
	private String designation;
	
	@Column(name="salary")
	private Double salary;
	
	/**
	 * We need to add a date field to the Employee class. 
	 * We map this field to the database column, "date_of_birth". 
	 * Also, we make use of the @Temporal annotation. 
	 * This is a Java annotation for storing dates.
	 */
	@Column(name="date_of_birth")
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	
	public Employee() {
		
	}

	public Employee(String firstName, String lastName, String email, String desg, Double salary) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.designation=desg;
		this.salary = salary;
	}
	
	public Employee(String firstName, String lastName, String email, String desg, Double salary, Date theDateOfBirth) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.designation=desg;
		this.salary = salary;
		this.dateOfBirth=theDateOfBirth;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the designation
	 */
	public String getDesignation() {
		return designation;
	}

	/**
	 * @param designation the designation to set
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	/**
	 * @return the salary
	 */
	public Double getSalary() {
		return salary;
	}

	/**
	 * @param salary the salary to set
	 */
	public void setSalary(Double salary) {
		this.salary = salary;
	}

	/**
	 * @return the dateOfBirth
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		String employee = "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + 
				", designation="+designation+", salary="+salary; 
		employee =  employee + ((dateOfBirth!=null) ?(" dateOfBirth=" + DateUtils.formatDate(dateOfBirth)):"" + "]");
		return employee;
	}

}
