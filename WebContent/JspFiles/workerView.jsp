<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="ISO-8859-1">
		<title>Worker View</title>
	</head>
	
	<body>
		
		<br><br><br>
		
		<div align="center"> 		 
			
			
			<hr>
			<br>
			
			<form name="manageTasksForm" action="http://localhost:8080/ProjectManagment/WorkerTasksServlet">
				<button  form="manageTasksForm" type = "submit" style="width:150px">Manage Tasks</button>
			</form>
									
		</div>
		
		<br><br>
		
		<div align="center">
		
			<form name="logoutForm" action="http://localhost:8080/ProjectManagment/LogoutManagerServlet">
				<button form="logoutForm" name="logout_button" type="submit" value="logout_worker" style="width:150px">Logout</button>
			</form>
		
		<br>
		<hr>
		
		</div>
		
	</body>
	
</html>