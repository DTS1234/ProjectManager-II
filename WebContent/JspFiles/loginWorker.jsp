<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Login Worker</title>
	</head>
	
	<body>
		
		<div align="center">
		
			<form name="loginForm" action="http://localhost:8080/ProjectManagment/LoginWorkerServlet" method="post" >
				
				<div class="container">
					
					<label for="login"><b>Login</b></label>						
					<br>
					<input name="login" type="text" form="loginForm" required></input>
					<br>
					<br>
					<label for="psw"><b>Password</b></label>
					<br>				
					<input name="psw" type="password" form="loginForm" required></input>
					<br><br>
					<button type="submit">Submit</button>
				
				</div>
				
			</form>
		
			<form name="backForm" action="http://localhost:8080/ProjectManagment/JspFiles/Welcome.jsp">
			
				<button type="submit">back</button>
			
			</form>
		
		</div>	
		
	</body>
	
</html>