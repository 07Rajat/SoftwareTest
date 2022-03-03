package com.serv1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class patientregistration
 */
import java.sql.*;

@WebServlet("/patientregistration")
public class patientregistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
     
    public patientregistration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out= response.getWriter();
		String name=request.getParameter("p_name");
		int age=Integer.parseInt(request.getParameter("p_age"));
		
		String address=request.getParameter("p_address");
        try {
        	Class.forName("com.mysql.jdbc.Driver"); //classnotfoundException
   	 
		 Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/hms","root","");
		  
		 Statement s = con.createStatement();
	     s.execute("insert into patientreg values('"+name+"','"+age+"','"+address+"')");
		
	}catch(Exception ee) {
		System.out.println(ee.getMessage());
	}
	}

	 

}
