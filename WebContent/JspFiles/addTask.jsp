<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="ISO-8859-1">
		<title>Add task</title>
	</head>
	
	<body>
		
		<form name="createTaskForm" action="http://localhost:5812/ProjectManagment/AddTaskToProject">
				<label for="task_name"><b>Task Name</b></label>						
				<br>
				<input name="task_name" type="text" form="createTaskForm" required></input>
				<br><br>
				<label for="task_id"><b>Task ID</b></label>
				<br>				
				<input name="task_id" type="number" form="createTaskForm" required></input>
				<br><br>
				<label for="task_planned"><b>Task planned deadline</b></label>
				<br>
				<input name="task_planned" type="date" form="createTaskForm" required></input>
				<br><br>
				<label for="project_id"><b>Project ID</b></label>
				<br>				
				<input name="project_id" type="number" form="createTasktForm" required></input>
				<br><br>
				<button form="createTaskForm" type="submit">Submit</button>		
		</form>
		
		<br><br><br>
		
		<form action="http://localhost:5812/ProjectManagment/JspFiles/managerView.jsp">	
			
			<button type="submit" >Back</button>
			
		</form>
		
	</body>
	
</html>