package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost/postgres";
		String user = "postgres";
		String password = "password";
		
		try {
			System.out.println("Connecting to Postgress DB Server....");
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("Connection successful.");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
