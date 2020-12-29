package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchname = request.getParameter("username");
		String searchemail = request.getParameter("password");

		String sql = "select username, password from employee";
		try {
			Class.forName("org.h2.Driver");
			Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
		
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			boolean userFound = false;
			
			while (rs.next()) {
				String name = rs.getString(1);
				String pass = rs.getString(2);
				if (searchname.equals(name) && searchemail.equals(pass)) {
					response.getWriter().println("Login Successful");
					userFound = true;
					
					HttpSession session= request.getSession();
					
					session.setAttribute("sesname", name);
					
					response.sendRedirect("loginsuccess.jsp");
					
					
					break;
				}
			}
			if (!userFound) {
				response.getWriter().println("Username and password do not match our records");
			}
		} catch (Exception e) {
			
		}
	}
}

