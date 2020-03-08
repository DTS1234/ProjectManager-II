package digital.content.managment.services;

import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import digital.content.managment.dao.ManagerDao;

public class ManagerService {
	
	private static boolean isLogged = false;
	private static String loginId = "";

	public void createProject() {
		
	}
	
	public boolean loginManager(String password, String id) throws ClassNotFoundException, SQLException {
		
		ManagerDao manager = new ManagerDao();
		
		if(manager.checkLogin(password, id)) {
			return true;
		}
		
		return false;
	}

	public void setLogged(boolean b) {
		ManagerService.isLogged = b;
	}
		
	public static boolean isLogged() {
		return isLogged;
	}
	
	public void createProjectService(String name, String id, String managerId) throws ClassNotFoundException, SQLException {
		
		ManagerDao managerDao = new ManagerDao();
		managerDao.createProject(name, id, managerId);
		
	}
	
	public void addTaskToProject(String id, String name, String projectId, String deadLine, String taskStart, String taskDependency) throws SQLException, ClassNotFoundException {
		
		ManagerDao managerDao = new ManagerDao();
		managerDao.createTask(id, name, projectId, deadLine, taskStart, taskDependency);
		
	}

	public List<String> createTasksList(String projectId) throws ClassNotFoundException, SQLException{
		
		ManagerDao managerDao = new ManagerDao();
		ResultSet query = managerDao.createTaskTable(projectId);
		List<String> taskList = new ArrayList<String>();
		
		while(query.next()) {
			taskList.add(query.getObject(1).toString());
		}
		
		return taskList;
	}

	public List<String> createTasksList2() throws ClassNotFoundException, SQLException{
		
		ManagerDao managerDao = new ManagerDao();
		ResultSet query = managerDao.createTaskTable2();
		List<String> taskList = new ArrayList<String>();
		
		while(query.next()) {
			taskList.add(query.getObject(1).toString());
		}
		
		return taskList;
	}
	
	
	public List<String> createWorkersList(String projectId) throws ClassNotFoundException, SQLException{
		
		ManagerDao managerDao = new ManagerDao();
		ResultSet query = managerDao.createAvaialalbleWorkers(projectId);
		List<String> workersList = new ArrayList<String>();
		
		while(query.next()) {
			workersList.add(query.getObject(1).toString());
		}
		
		return workersList;
	}
	
	public List<String> createProjectsList(String managerId) throws ClassNotFoundException, SQLException{
		
		ManagerDao managerDao = new ManagerDao();
		ResultSet query = managerDao.createProjectsTable(managerId);
		List<String> projectsList = new ArrayList<String>();
		
		while(query.next()) {
			projectsList.add(query.getObject(1).toString());
		}
		
		return projectsList;

	}
	
	public String findIdOfWorker(String name) throws SQLException, ClassNotFoundException{
		
		ManagerDao managerDao = new ManagerDao();
		ResultSet query = managerDao.findId("worker_id", "workers", "worker_name", name);
		String id = "";
		
		while(query.next()) {
			id = query.getObject(1).toString();
		}
		
		return id;
	}
	
	public String findIdOfTask(String name) throws SQLException, ClassNotFoundException{
		
		ManagerDao managerDao = new ManagerDao();
		ResultSet query = managerDao.findId("task_id", "tasks", "task_name", name);
		String id = "";
		
		while(query.next()) {
			id = query.getObject(1).toString();
		}
		
		return id;
	}
	
	public String findIdOfProject(String name) throws SQLException, ClassNotFoundException{
		
		ManagerDao managerDao = new ManagerDao();
		ResultSet query = managerDao.findId("project_id", "projects", "project_name", name);
		String id = "";
		
		while(query.next()) {
			id = query.getObject(1).toString();
		}
		
		return id;
	}
	
	public String stylingMethod() {
		String styling = "<style>\r\n" + 
				"table, td, th {  \r\n" + 
				"  border: 1px solid #ddd;\r\n" + 
				"  text-align: left;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"table {\r\n" + 
				"  border-collapse: collapse;\r\n" + 
				"  width: 100%;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"th, td {\r\n" + 
				"  padding: 15px;\r\n" + 
				"}\r\n" + "html{font-family:\"Trebuchet MS\", Helvetica, sans-serif}" +
				
				"</style>";
		return styling;
	}

	
	public void listProjects(PrintWriter out, String managerId) throws SQLException, ClassNotFoundException {//parametr out podany jako printer w servlecie
		
			ManagerDao managerDao = new ManagerDao();
			ResultSet projectSet = managerDao.createUniqueSet("projects", "manager_id", managerId);//tworzymy tablice z projektami
			ResultSetMetaData col = projectSet.getMetaData();
			int colInt = col.getColumnCount();//pobieramy liczbe kolumn
			
			out.println(stylingMethod());
			
			out.println("<h3>Your projects</h3>");
			
			out.println("<table align='center' border=\"1\">");
			
			out.println("<tr>");
			
			for (int i=1; i <= colInt; i++) 
    	    {
				out.println("<th>");
				out.println(col.getColumnLabel(i));
				out.println("</th>");
    	    }
			
			out.println("</tr>");
			
			while(projectSet.next()) {
				
				out.println("<tr>");
				
				for (int i=1; i <= colInt; i++) 
        	    {
        	        Object value = projectSet.getObject(i);
        	        out.println("<td>");
        	        
        	        if (value != null) 
        	        {
        	            out.println(value.toString());
        	        }
        	        
        	        out.println("</td>");
        	        
        	    }
					
				out.println("</tr>");
			
			}
						
			out.println("</table>");			
			
			out.println("<br><br>");
			
			out.println("<form action='http://localhost:8080/ProjectManagment/ShowProjectsTasks'>");
//			out.println("<label for=\"project_id\"><b>Enter Project Id to see it's tasks</b></label>" + 
//					"<br>" + 
//					"<input name=\"project_id\" type=\"number\" form=\"assignForm\" required></input>");
			
			out.println("<select name='project'>");
			
			for(String project: createProjectsList(managerId)) {
				System.out.println(project);
				out.println("<option>"+project+"</option>");
			}
			
			out.println("</select>");
			
			
			out.println("<button name='task_button'type='submit'>show tasks</button>");
			out.println("</form>");
			
			out.println("<br><br>");
			
			out.println("<form action='http://localhost:8080/ProjectManagment/JspFiles/manageProjects.jsp'>");
			out.println("<button name='menu_button'type='submit'>back to menu</button>");
			out.println("</form>");
			
	}
	
	public  void listTasks(PrintWriter out, String searchedId) throws SQLException, ClassNotFoundException {//parametr out podany jako printer w servlecie
		
			ManagerDao managerDao = new ManagerDao();
			
			ResultSet taskSet = managerDao.createUniqueSet("tasks", "project_id", searchedId);//searchedId podane w servlecie
			ResultSetMetaData col = taskSet.getMetaData();
			int colInt = col.getColumnCount();//pobieramy liczbe kolumn
			
			out.println(stylingMethod());
			
			out.println("<h3>Project's tasks</h3>");

			
			out.println("<table align='center' border=\"1\">");
			
			out.println("<tr>");
			for (int i=1; i <= colInt; i++) 
    	    {
				out.println("<th>");
				out.println(col.getColumnLabel(i));
				out.println("</th>");
    	    }
				
			out.println("</tr>");
			
			while(taskSet.next()) {
				
				out.println("<tr>");
				
				for (int i=1; i <= colInt; i++) 
        	    {
        	        Object value = taskSet.getObject(i);
        	        out.println("<td>");
       	        
        	        if (value != null) 
        	        {
        	            out.println(value.toString());
        	        }       	        
        	        
        	    }
				
				out.println("</tr>");
			
			}
			
			out.println("</table>");
						
		}
	
	public void assignService(String taskId, String workerId) throws SQLException, ClassNotFoundException {
		
		ManagerDao managerDao = new ManagerDao();
		managerDao.addWorkerToTask(taskId, workerId);
		
	}
	
	public void printAvailableWorkers(PrintWriter out, String projectId) throws SQLException, ClassNotFoundException {
		
		ManagerDao managerDao = new ManagerDao();
		ResultSet table = managerDao.printAvailabaleWorkers(projectId);
		
		ResultSetMetaData col = table.getMetaData();
		int colInt = col.getColumnCount();//pobieramy liczbe kolumn
		
		out.println("<h3>Available workers</h3>");
		
		out.println(stylingMethod());
		
		out.println("<table border=\"1\">");
		
		out.println("<tr>");
		for (int i=1; i <= colInt; i++) 
	    {
			out.println("<th>");
			out.println(col.getColumnLabel(i));
			out.println("</th>");
	    }
				
		out.println("</tr>");
		
		while(table.next()) {
			
			out.println("<tr>");
			
			for (int i=1; i <= colInt; i++) 
    	    {
    	        Object value = table.getObject(i);
    	        out.println("<td>");
    	        
    	        if (value != null) 
    	        {
    	            out.println(value.toString());
    	            
    	        }
    	        
    	        out.println("</td>");
    	        
    	    }
						
			out.println("</tr>");
		
		}
					
		out.println("</table>");			
		
		out.println("<br>");
		
		out.println("<form action='http://localhost:8080/ProjectManagment/JspFiles/manageProjects.jsp'>");
		out.println("<button name='menu_button'type='submit'>back to menu</button>");
		out.println("</form>");
	}
	
	public void printWorkersAndTasks(PrintWriter out, String projectId) throws ClassNotFoundException, SQLException {

		ManagerDao managerDao = new ManagerDao();
		ResultSet table = managerDao.printWorkersAndTasks(projectId);
		
		ResultSetMetaData col = table.getMetaData();
		int colInt = col.getColumnCount();//pobieramy liczbe kolumn
		
		out.println(stylingMethod());
		
		out.println("<br><br>");

		out.println("<h3>Tasks assignments</h3>");
		
		out.println("<table border=\"1\">");
		
		out.println("<tr>");
		for (int i=1; i <= colInt; i++) 
	    {
			out.println("<th>");
			out.println(col.getColumnLabel(i));
			out.println("</th>");
	    }
				
		out.println("</tr>");
		
		while(table.next()) {
			
			out.println("<tr>");
			
			for (int i=1; i <= colInt; i++) 
    	    {
    	        Object value = table.getObject(i);
    	        out.println("<td>");
    	        
    	        if (value != null) 
    	        {
    	            out.println(value.toString());
    	            
    	        }
    	        
    	        out.println("</td>");
    	        
    	    }
						
			out.println("</tr>");
		
		}
					
		out.println("</table>");			
		
		out.println("<br>");
		
		out.println("<form action='http://localhost:8080/ProjectManagment/AssignWorkerServlet'>");
		out.println("<button name='assign_button' value = '"+projectId+"'type='submit'>assign worker to task</button>");
		out.println("</form>");
		
		out.println("<br><br>");
		
		
	}
	
	public boolean checkIfTasksAreDone(String projectId) throws SQLException, ClassNotFoundException {
		
		ManagerDao managerDao = new ManagerDao();
		ResultSet query = managerDao.checkIfTasksAreDone(projectId);		
		
		if(!query.next()) {
			return true;
		}
		
		return false;
		
	}
	
	public boolean chechDependecy(String taskId) throws ClassNotFoundException, SQLException {
		
		ManagerDao managerDao = new ManagerDao();
		ResultSet queryDep = managerDao.taksDependencySet(taskId);
		String taskDep = "";
		
		while(queryDep.next()) {
			taskDep = (String) queryDep.getObject(1);
		}
		
		if(taskDep.equals("no dependency")) {
			return true;
		}else {
			return managerDao.checkIfTasksIsDone(taskId);
		}
		
	}
	
	public void setLoginId(String loginId) {
		ManagerService.loginId = loginId;
	}
	
	public String getLoginId() {
		return loginId;
	}
	
	public void finishProject(String projectId) throws ClassNotFoundException, SQLException {
		
		ManagerDao managerDao = new ManagerDao();
		managerDao.deleteAssignments(projectId);
		managerDao.delete(projectId, "projects", "project_id");
		
	}
	
}
	
	

