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
		response.setHeader("cache-control","no-cache");
		response.setHeader("cache-control","no-store");
		response.setHeader("cache-control","must-revalidate");
		response.setDateHeader("Expire", 0);
	%>
	<h1>Login Successful</h1>
	
	<a href="Balance">Check Balance</a><hr><br>
	<a href="ChangePwd.html">Change Password</a><hr><br>
	<a href="amountTransfer.html">TransferAmount</a><hr><br>
	<a href="getTransactionDetails">Get All Transaction Details</a><hr><br>
	<a href="loan.html">Apply Loan</a>
	<div align="right">
		<a href="logout">Logout</a>
	</div>
	
</body>
</html>