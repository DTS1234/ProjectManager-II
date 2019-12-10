<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/managerView.css" />
		<title>Manager View</title>
	</head>
	
	<body>
		
		<div align="center"> 
		
			<form name="manageProjectsForm" action="http://localhost:5812/ProjectManagment/ManageProjectsServlet">
				<button form="manageProjectsForm" type = "submit">Manage Projects</button>
			</form>
			
			<form name="createProjectForm" action="http://localhost:5812/ProjectManagment/CreateProjectServlet">
				<button form="createProjectForm" type="submit">Create new project</button>
			</form>
			
			<form name="finishProjectForm" action="http://localhost:5812/ProjectManagment/FinishProjectServlet">
				<button form="finishProjectForm" type="submit">Finish project</button>
			</form>
						
		</div>
		<br><br><br><br><br><br>
		
		<div align="center">
		
			<form name="logoutForm" action="http://localhost:5812/ProjectManagment/LogoutManagerServlet">
				<button form="logoutForm" name="logout_button" type="submit" value="logout">Logout</button>
			</form>
			
		</div>
		
	</body>

</html>