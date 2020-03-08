<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create manager</title>
</head>
<body>
	
	<form name="createManagerForm" action = "http://localhost:8080/ProjectManagment/CreateManagerServlet">
			<label for="manager_name"><b>Manager Name</b></label>						
			<br>
			<input name="manager_name" form="createManagerForm" required></input>
			<br><br>
			<label for="manager_id"><b>Manager ID</b></label>
			<br>				
			<input name="manager_id" form="createManagerForm" required></input>
			<br><br>
			<label for="manager_password"><b>Manager password</b></label>
			<br>
			<input name="manager_password" form="createManagerForm" required></input>
			<br><br>
			<button form="createWorkerForm" type="submit">Submit</button>		
	</form>
	
	<form action="http://localhost:8080/ProjectManagment/JspFiles/adminView.jsp">	
			
			<button type="submit" >Back</button>
			
	</form>
	
</body>
</html>