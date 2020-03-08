<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="ISO-8859-1">
		<title>Finish Task</title>
	</head>

	<body>
	
		<div align="center">
		<form name="finishTaskForm" action="http://localhost:8080/ProjectManagment/FinishTaskServlet">
		
			<label for="task_id"><b>Task Id</b></label>
			<br>				
			<input name="task_id" type="text" form="finishTaskForm" required></input>
			<br><br>
			<label for="task_name"><b>Task name</b></label>
			<br>				
			<input name="task_name" type="text" form="finishTaskForm" required></input>
			<br><br>
			<button form="finishTaskForm" type="submit">Submit</button>
		
		</form>
		
		<br><br><br>
		
		<form action="http://localhost:8080/ProjectManagment/WorkerTasksServlet">	
			
			<button type="submit" >Back</button>
			
		</form>
		</div>
	</body>

</html>