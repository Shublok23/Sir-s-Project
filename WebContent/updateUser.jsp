<!DOCTYPE html>
<%@page import="com.pojo.web"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% web w=(web)session.getAttribute("w"); %>
	<form action="MyServlet" method="post">
	<input type="hidden" name="action" value="updateUser"> 
		<table>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name" value="<%=w.getName()%>"></td>
			</tr>
			<tr>
				<td>Contact:</td>
				<td><input type="text" name="contact" value="<%=w.getContact()%>"></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="text" name="email" value="<%=w.getEmail()%>" readonly="readonly"></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="text" name="pass" value="<%=w.getPass()%>"></td>
			</tr>
			<tr>
				<td><input type="submit" value="submit"></td>
			</tr>
		</table>

	</form>

</body>
</html>