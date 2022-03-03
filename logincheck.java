package com.serv1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/log")

public class logincheck extends HttpServlet 
{    
 	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   
 	 PrintWriter out= response.getWriter();
	 String u  =request.getParameter("username");
	 String p=request.getParameter("password");
	 
	 String role=request.getParameter("role");
	 try{Class.forName("com.mysql.jdbc.Driver");
	 

		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hms","root","");

		Statement s=con.createStatement();
    
		ResultSet rs= s.executeQuery("select * from login where username='"+u+"' and password='"+p+"'");
		 
		if(rs.next()) {
			
		
		if(role.equals("Doctor"))
		{
			RequestDispatcher rd= request.getRequestDispatcher("doctor.html");
			rd.forward(request, response);
			// out.println("Username: "+rs.getString(1)+" and Password: "+rs.getString(2));
		}
		else if(role.equals("patient"))
		{
			RequestDispatcher rd= request.getRequestDispatcher("patient.html");
			rd.forward(request, response);
			
		}
		else if(role.equals("staff"))
		{
			RequestDispatcher rd= request.getRequestDispatcher("staff.html");
			rd.forward(request, response);
			
		}}
		else
			response.sendRedirect("login.html");
	 }catch(Exception ee) {System.out.println(ee.getMessage());
	 }

 		
 	}
 	
}
