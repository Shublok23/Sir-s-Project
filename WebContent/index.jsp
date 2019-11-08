<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
String user=(String)session.getAttribute("user");
String admin=(String)session.getAttribute("admin");
%>

	<%if(user!=null && admin==null){ %>
	<h1>
		<a href="#">AddIncome</a>
	</h1>
	<h1>
		<a href="#">IncomeList</a>
	</h1>
	<h1>
		<a href="#">AddExpense</a>
	</h1>
	<h1>
		<a href="#">Expense List</a>
	</h1>
	<%}%>
	<%if(admin!=null && user==null){ %>
	
	<h1>
		<a href="MyServlet">UserList</a>
	</h1>
	<%} %>
	
	
	<%if(user==null && admin==null){ %>
	<h1>
		<a href="registration.html">REGISTER</a>
	</h1>
	<h1>
		<a href="login.jsp">Login</a>
	</h1>
	
	<h1>
		<a href="#">AboutUs</a>
	</h1>
	
	<%} %>


	<%if(user!=null || admin!=null) {%>
	<h1>
		<a href="LoginServlet">LogOut</a>
	</h1>
	
	
	<%} %>
</body>
</html>
