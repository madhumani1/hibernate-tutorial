/**
 * 
 */
package com.java.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author 15197
 * This program will test JDBC
 */
public class TestJdbc {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";	// useSSL=false is to get rid of SSL warning
		String user="hbstudent";
		String passwd="hbstudent";
		
		try	{
			System.out.println("Connecting to database: "+jdbcUrl);
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, passwd);
			System.out.println("Connection successful!!!");
			
		}	catch (Exception e) {
			e.printStackTrace();
		}
	}

}
