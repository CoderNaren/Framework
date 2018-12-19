package com.Login.TestConnection;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

@WebServlet("/TestDbServlet")
public class DB_Servlet_testing extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String user = "system";
		String pass = "admin";
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/login?useSSL=false";
		String driver = "com.mysql.jdbc.Driver";
		
		try {
			PrintWriter out = response.getWriter();
			out.println("connecting to DB "+jdbcUrl);
			
			Class.forName(driver);
			
			Connection myConn = DriverManager.getConnection(jdbcUrl,user,pass);
			
			out.println("\n\n Done!!	");
			
			myConn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

}
