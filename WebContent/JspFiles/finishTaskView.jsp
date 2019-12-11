<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="ISO-8859-1">
		<title>Finish Task</title>
	</head>

	<body>
	
		<form name="finishTaskForm" action="FinishTaskServlet">
		
			<label for="task_real_date"><b>Task Id</b></label>						
			<br>
			<input name="task_real_date" type="date" form="finishTaskForm" required></input>
			<br><br>
			<label for="task_id"><b>Worker Id</b></label>
			<br>				
			<input name="task_name" type="number" form="finishTaskForm" required></input>
			<br><br>
			<button form="finishTaskForm" type="submit">Submit</button>
		
		</form>
	
	</body>

</html>