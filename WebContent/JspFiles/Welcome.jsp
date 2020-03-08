<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/Welcome.css" />
		<title>Welcome!</title>
	</head>
	
	<body>
		
		<div align="center" style="margin:50px">
			<hr>
			<h1 id = 'welcome'>Choose your role !</h1>
			
			<form action="login.jsp">
				<button style="width:150px" type="submit">Manager</button>
			</form>
		
			<form action="loginWorker.jsp">
				<button style="width:150px" type="submit">Worker</button>
			</form>
			<br>
			<hr>
		</div>
		
	</body>
	
</html>