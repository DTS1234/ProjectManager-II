<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="ISO-8859-1">
		<title>Admin View</title>
	</head>
	
	<body>
		
		<form action="http://localhost:8080/ProjectManagment/JspFiles/createWorker.jsp"> 
		
			<button type="submit">Create Worker</button>
		
		</form>
		
		<form action="http://localhost:8080/ProjectManagment/JspFiles/createManager.jsp"> 
		
			<button type="submit">Create Manager</button>
		
		</form>
		
		
		<form action="http://localhost:8080/ProjectManagment/ListAdminTasksServlet"> 
		
			<button type="submit">Show Tasks</button>
		
		</form>
		
		<form action="http://localhost:8080/ProjectManagment/ListAdminProjectsServlet"> 
		
			<button type="submit">Show Projects</button>
		
		</form>
		
		<form action="http://localhost:8080/ProjectManagment/JspFiles/Welcome.jsp">	
			
			<button type="submit" >Back</button>
			
		</form>
		
	</body>

</html>