<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Loan SuccessFull</h1>
	<h2>Principle :<% out.print(session.getAttribute("pri"));%></h2>
	<h2>Time :<% out.print(session.getAttribute("time"));%></h2>
	<h2>Rate :<% out.print(session.getAttribute("rate"));%></h2>
	<h2>Simple Interest :<% out.print(session.getAttribute("si"));%></h2>
</body>
</html>