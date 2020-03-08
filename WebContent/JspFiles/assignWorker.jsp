<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Assign worker</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/asignWorker.css" />

	</head>
	<body>
		<div class="view" align="center">
			
			<form name="assignForm" action="http://localhost:8080/ProjectManagment/AssignWorkerServlet">	
				<label for="taks_id"><b>Task Id</b></label>						
				<br>
				<select name="tasks">
					<c:forEach items="${tasks}" var="current">
	          			<option><c:out value="${current}" /></option>
	          		</c:forEach>
				</select>
				<br><br>
				<label for="worker_id"><b>Worker Id</b></label>
				<br>
				<select name="workers">
					<c:forEach items="${workers}" var="current">
	          			<option><c:out value="${current}" /></option>
	          		</c:forEach>
				</select>
				<br><br>
				<button form="assignForm" type="submit">Submit</button>		
			</form>
			
			<form action="http://localhost:8080/ProjectManagment/ListProjectsServlet">
			
				<button type="submit">Projects View</button>
			
			</form>
		
		</div>
	</body>
</html>