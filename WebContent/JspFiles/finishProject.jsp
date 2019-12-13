<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="ISO-8859-1">
		<title>Finish Task</title>
	</head>
	
	<body>
		
		<form action = "http://localhost:8080/ProjectManagment/FinishProjectServlet">
			
			<label for="project_name"><b>Project Name</b></label>						
			<br>
			<input name="project_name" required></input>
			<br><br>
			<label for="project_id"><b>Project ID</b></label>
			<br>				
			<input name="project_id" required></input>
			<br><br>
			<button type="submit">Submit</button>	
			
		</form>
		
	</body>

</html>