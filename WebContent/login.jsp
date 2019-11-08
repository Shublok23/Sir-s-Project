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
		String lmsg = (String) request.getAttribute("lmsg");
	if(lmsg!=null){
	%>
	<h2 align="center" style="color: red;"><%=lmsg %></h2>
	<% }%>

	<form action="LoginServlet" method="post">

		<table align="center" cellpadding="10" cellspacing="10" border="1">

			<tr>
				<td>UserName</td>
				<td><input type="text" name="uname"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="text" name="pass"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Login"></td>
			</tr>
		</table>

	</form>

</body>
</html>