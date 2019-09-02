package com.crm.web.testdb;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

	public static void main(String[] args) {
		/*String url = "jdbc:postgresql://localhost/web_customer_tracker";
		String user = "postgres";
		String password = "password";*/
		
		String user = "springstudent";
		String pass = "password";		
		String url = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";
		//String driver = "com.mysql.cj.jdbc.Driver";
		
		try {
			System.out.println("Connecting to Postgress DB Server....");
			Connection conn = DriverManager.getConnection(url, user, pass);
			System.out.println("Connection successful.");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
