<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	
	<head>
		<meta charset="ISO-8859-1">
		<title>Manage Projects</title>
	</head>
	
	<body>
		
		<form action="http://localhost:8080/ProjectManagment/ListProjectsServlet">
			
			<button>List Projects</button>
		
		</form>
		<br>
		<form action="http://localhost:8080/ProjectManagment/JspFiles/addTask.jsp">	
			
			<button type="submit" >Add task to project</button>
			
		</form>	
		
		<br>
		<br>
		<br>
		
		<form action="http://localhost:8080/ProjectManagment/JspFiles/managerView.jsp">	
			
			<button type="submit" >Back</button>
			
		</form>	
		
	</body>
	
</html>