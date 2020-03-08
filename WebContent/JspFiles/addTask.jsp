<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>

	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/addTask.css" />
		<title>Add task</title>
	</head>
	
	<body>
		<div align="center">
	
			<form name="createTaskForm" action="http://localhost:8080/ProjectManagment/AddTaskToProject">
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
			
				<label for="project_id"><b>Available Projects:</b></label>
				<br>				
				<select style="width:155px" name="projects">
					<c:forEach items="${projects}" var="current">
	          			<option><c:out value="${current}" /></option>
	          		</c:forEach>
				</select>
				<br><br>			
				<label for="task_start_date"><b>Task start date</b></label>
				<br>				
				<input name="task_start_date" type="date" form="createTasktForm" required></input>
				<br><br>
				<label for="task_dependency"><b>Tasks available:</b></label>
				<br>
				<select style="width:155px" name="tasks">
					<c:forEach items="${tasks}" var="current">
	          			<option><c:out value="${current}" /></option>
	          		</c:forEach>
	           		<option>no dependency</option>       		
				</select>
				
				<br><br>
				<button form="createTaskForm" type="submit">Submit</button>		
			</form>
			
			<br>
		
			<form action="http://localhost:8080/ProjectManagment/JspFiles/manageProjects.jsp">	
				<button type="submit" >Back</button>
			</form>
				
		</div>
		
		
		
	</body>
	
</html>