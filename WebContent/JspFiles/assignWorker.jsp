<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<form name="assignForm" action="http://localhost:5812/ProjectManagment/AssignWorkerServlet">
			<label for="taks_id"><b>Task Id</b></label>						
			<br>
			<input name="task_id" type="number" form="assignForm" required></input>
			<br><br>
			<label for="worker_id"><b>Worker Id</b></label>
			<br>				
			<input name="worker_id" type="number" form="assignForm" required></input>
			<br><br>
			<button form="assignForm" type="submit">Submit</button>		
	</form>
	
</body>
</html>