<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ page language="java" import="java.sql.*" %>
<%@ page language="java" import="javax.servlet.http.HttpSession"  %>
<%

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

%>
</body>
</html>