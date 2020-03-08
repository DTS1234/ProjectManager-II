<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	
	<head>
		<meta charset="ISO-8859-1">
		<title>Manage Projects</title>
	</head>
	
	<body>
		
		<div align="center">
		
		<form action="http://localhost:8080/ProjectManagment/ListProjectsServlet">
			
			<button style="width:150px">List Projects</button>
		
		</form>
		<br>
		<form action="http://localhost:8080/ProjectManagment/AddTaskToProject">	
			
			<button style="width:150px" type="submit">Add task to project</button>
			
		</form>	
		
		<br>
		<br>
		<br>
		
		<form action="http://localhost:8080/ProjectManagment/JspFiles/managerView.jsp">	
			
			<button style="width:150px" type="submit" >Back</button>
			
		</form>	
		
		</div>
	</body>
	
</html>