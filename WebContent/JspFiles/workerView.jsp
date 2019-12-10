<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	
	<body>
		
		<div align="center"> 
		
			<form name="manageTasksForm" action="http://localhost:5812/ProjectManagment/TaskViewWorkerServlet">
				<button form="manageTasksForm" type = "submit">Manage Projects</button>
			</form>
									
		</div>
		<br><br><br><br><br><br>
		
		<div align="center">
		
			<form name="logoutForm" action="http://localhost:5812/ProjectManagment/LogoutManagerServlet">
				<button form="logoutForm" name="logout_button" type="submit" value="logout_worker">Logout</button>
			</form>
			
		</div>
		
	</body>
	
</html>