package digital.content.managment.services;

import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import digital.content.managment.dao.ClassDao;

public class AdminService {
	
	public void createWorker(String workerId, String workerName, String workerPassword) throws ClassNotFoundException, SQLException {
		ClassDao classDao = new ClassDao();
		classDao.createUser(workerId, workerName, workerPassword);
	}
	
	public void createManager(String managerId, String managerName, String managerPassword) throws ClassNotFoundException, SQLException {
		ClassDao classDao = new ClassDao();
		classDao.createManager(managerId, managerName, managerPassword);
	}

	public void printProjects(PrintWriter out) throws SQLException, ClassNotFoundException {
		
		ClassDao classDao = new ClassDao();
		ResultSet projectSet = classDao.createSet("projects");//tworzymy tablice z projektami
		ResultSetMetaData col = projectSet.getMetaData();
		int colInt = col.getColumnCount();//pobieramy liczbe kolumn
		
		out.println("<head>");
		out.println("<link rel='stylesheet' type='text/css' href='http://localhost:8080/ProjectManagment/CSS/listProjects.css/'>");			
		out.println("</head>");			
		
		out.println("<table border=\"1\">");
		
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
		
		out.println("<form action='http://localhost:8080/ProjectManagment/JspFiles/adminView.jsp'>");
		out.println("<button name='menu_button'type='submit'>back to menu</button>");
		out.println("</form>");
	}
	
	public void printTasks(PrintWriter out) throws SQLException, ClassNotFoundException {
		
		ClassDao classDao = new ClassDao();
		ResultSet projectSet = classDao.createSet("tasks");//tworzymy tablice z projektami
		ResultSetMetaData col = projectSet.getMetaData();
		int colInt = col.getColumnCount();//pobieramy liczbe kolumn
		
		out.println("<head>");
		out.println("<link rel='stylesheet' type='text/css' href='http://localhost:8080/ProjectManagment/CSS/listProjects.css/'>");			
		out.println("</head>");			
		
		out.println("<table border=\"1\">");
		
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
					
		
		
		out.println("<br><br>");
		
		out.println("<form action='http://localhost:8080/ProjectManagment/JspFiles/adminView.jsp'>");
		out.println("<button name='menu_button'type='submit'>back to menu</button>");
		out.println("</form>");
	}
	
}
