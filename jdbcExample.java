package com.serv1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
 
@WebServlet("/jdbcExample")
public class jdbcExample extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
	     PrintWriter out= response.getWriter();
		Class.forName("com.mysql.jdbc.Driver");
 

		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hms","root","");

 
		Statement s=con.createStatement();

		ResultSet rs= s.executeQuery("select * from LOGIN");

		while(rs.next())
		{
			 out.println("Username: "+rs.getString(1)+" and Password: "+rs.getString(2));
		}

		}
	catch(SQLException e)
	{
		System.out.println(e.getMessage());

	}
	catch(ClassNotFoundException e)
	{
		System.out.println("class not found"+ e.getMessage());
	}

	}
 
	}

 
