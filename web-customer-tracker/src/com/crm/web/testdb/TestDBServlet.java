package com.crm.web.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDBServlet
 */
@WebServlet("/TestDBServlet")
public class TestDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*String url = "jdbc:postgresql://localhost/web_customer_tracker";
		String user = "postgres";
		String password = "password";
		String driver ="org.postgresql.Driver";*/
		
		String user = "springstudent";
		String pass = "password";		
		String url = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";
		String driver = "com.mysql.cj.jdbc.Driver";
		
		Connection conn = null;
		try {
			PrintWriter out = response.getWriter();
			out.println("Connecting to Postgress DB Server...."+url);
			System.out.println("Connecting to Postgress DB Server...."+url);
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pass);
			out.println("Connection successful.");
			System.out.println("Connection successful.");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(conn!=null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
