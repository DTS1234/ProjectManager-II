package digital.content.managment.services;

import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import digital.content.managment.dao.ManagerDao;

public class ManagerService {
	
	private static boolean isLogged = false;
	
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
	
	public void addTaskToProject(String id, String name, String projectId, String deadLine) throws SQLException, ClassNotFoundException {
		
		ManagerDao managerDao = new ManagerDao();
		managerDao.createTask(id, name, projectId, deadLine);
		
	}

	public void listProjects(PrintWriter out) throws SQLException, ClassNotFoundException {//parametr out podany jako printer w servlecie
		
			ManagerDao managerDao = new ManagerDao();
			ResultSet projectSet = managerDao.createSet("projects");//tworzymy tablice z projektami
			ResultSetMetaData col = projectSet.getMetaData();
			int colInt = col.getColumnCount();//pobieramy liczbe kolumn
			
			out.println("<table border=\"1\">");
			
			out.println("<tr>");
			for (int i=1; i <= colInt; i++) 
    	    {
				out.println("<th>");
				out.println(col.getColumnLabel(i));
				out.println("</th>");
    	    }
			
			out.println("<th>");
			out.println("task details");
			out.println("</th>");
			
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
				
				
				
				out.println("<td>");//dodany button z taskami
				out.println("<form action='http://localhost:8080/ProjectManagment/ShowProjectsTasks'>");
				out.println("<button name='task_button'type='submit'>show tasks</button>");
				out.println("</form>");
				out.println("</td>");
							
				out.println("</tr>");
			
			}
						
			out.println("</table>");			
			
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
			
			out.println("<table border=\"1\">");
			
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
	
	public void printWorkersAndTasks(PrintWriter out) throws ClassNotFoundException, SQLException {

		ManagerDao managerDao = new ManagerDao();
		ResultSet table = managerDao.printWorkersAndTasks();
		
		ResultSetMetaData col = table.getMetaData();
		int colInt = col.getColumnCount();//pobieramy liczbe kolumn
		out.println("<br><br><br><br>");
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
		
		out.println("<form action='http://localhost:8080/ProjectManagment/JspFiles/assignWorker.jsp'>");
		out.println("<button name='assign_button'type='submit'>assign worker to task</button>");
		out.println("</form>");
		
		out.println("<br><br>");
		
		out.println("<form action='http://localhost:8080/ProjectManagment/JspFiles/manageProjects.jsp'>");
		out.println("<button name='menu_button'type='submit'>back to menu</button>");
		out.println("</form>");
		
		
	}
	
}
	
	

