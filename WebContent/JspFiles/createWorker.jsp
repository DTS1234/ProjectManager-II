<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="ISO-8859-1">
		<title>Create Worker</title>
	</head>

	<body>
		
		<form name="createWorkerForm" action = "http://localhost:8080/ProjectManagment/CreateWorkerServlet">
			<label for="worker_name"><b>Worker Name</b></label>						
			<br>
			<input name="worker_name" form="createWorkerForm" required></input>
			<br><br>
			<label for="worker_id"><b>Worker ID</b></label>
			<br>				
			<input name="worker_id" form="createWorkerForm" required></input>
			<br><br>
			<label for="worker_password"><b>Worker password</b></label>
			<br>
			<input name="worker_password" form="createWorkerForm" required></input>
			<br><br>
			<button form="createWorkerForm" type="submit">Submit</button>		
		</form>
		
	</body>

</html>