<%@page import="com.daoImpl.webDaoImpl"%>
<%@page import="com.pojo.web"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		List<web> wl=(List<web>)session.getAttribute("wlist");
	%>

	<table cellpadding="10" cellspacing="10" align="center" border="1">
		<tr>
			<th>Name</th>
			<th>Contact</th>
			<th>Email</th>
			<th>Pass</th>
			<th colspan="2">Action</th>
		</tr>
		<%
			for (web w : wl) {
		%>
		<tr>
		<td><%=w.getName() %></td>
		<td><%=w.getContact() %></td>
		<td><%=w.getEmail() %></td>
		<td><%=w.getPass() %></td>
		<td><a href="MyServlet?action=edit&email=<%=w.getEmail() %>">Edit</a></td>
		<td><a href="MyServlet?action=delete&email=<%=w.getEmail() %>">Delete</a></td>
		</tr>
		<%
			}
		%>


	</table>
</body>
</html>