<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
	<%!
		String balance;
	%>
<body>
		<h1> Hello User You Account Balance is</h1>
		<%
			balance=(String)session.getAttribute("Balance");
			out.print(balance);
		%>

</body>
</html>