package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 
@WebServlet("/helloapp")
public class WelcomeApp extends HttpServlet {
	 

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.getWriter().println("Welcome to my servlet");
		
		
		
	}

}
