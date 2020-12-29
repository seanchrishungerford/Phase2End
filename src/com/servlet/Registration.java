package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.UserService;

@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserService userService= new UserService();
		
		System.out.println("inside servlet");
		 
		com.model.Registration reg= new com.model.Registration(request.getParameter("username"), request.getParameter("password"));
		 
		userService.registration(reg);
		HttpSession session= request.getSession();
	
		session.setAttribute("sesname", request.getParameter("username"));
	
		response.sendRedirect("registersuccess.jsp");

	}

}
