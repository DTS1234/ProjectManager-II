<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	
	<head>
		<meta charset="ISO-8859-1">
		<title>Create Project</title>
	</head>
	
	<body>
		<form name="createProjectForm">
			<label for="project_name"><b>Project Name</b></label>						
			<br>
			<input name="project_name" form="createProjectForm" required></input>
			<br><br>
			<label for="project_id"><b>Project ID</b></label>
			<br>				
			<input name="project_id" form="createProjectForm" required></input>
			<br><br>
			<label for="manager_id"><b>Manager ID</b></label>
			<br>
			<input name="manager_id"  form="createProjectForm" required></input>
			<br><br>
			<button form="createProjectFrom" type="submit">Submit</button>		
		</form>
		
		<br><br><br>
		
		<form action="http://localhost:5812/ProjectManagment/JspFiles/managerView.jsp">	
			
			<button type="submit" >Back</button>
			
		</form>
		
	</body>

</html>