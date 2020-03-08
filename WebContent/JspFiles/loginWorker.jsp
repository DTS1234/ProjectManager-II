<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Login Worker</title>
	</head>
	
	<body>
		
		<div align="center" style="margin:50px">
			
			<hr>
			<br>			
			<form name="loginForm" action="http://localhost:8080/ProjectManagment/LoginWorkerServlet" method="post" >
					
					<label for="login"><b>Login</b></label>						
					<br>
					<input name="login" type="text" form="loginForm" required></input>
					<br>
					<br>
					<label for="psw"><b>Password</b></label>
					<br>				
					<input name="psw" type="password" form="loginForm" required></input>
					<br><br>
					<button style="width:150px" type="submit">Submit</button>				
			</form>
			
			<br>
			
			<form name="backForm" action="http://localhost:8080/ProjectManagment/JspFiles/Welcome.jsp">
			
				<button style="width:150px" type="submit">Back</button>
			
			</form>
			<br>
			<hr>
			
		</div>	
		
	</body>
	
</html>