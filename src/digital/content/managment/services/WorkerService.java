package digital.content.managment.services;

import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;

import digital.content.managment.dao.WorkerDao;

public class WorkerService {

	private static boolean isLogged = false;
	private static String loginId = "";
	
	public void setLogged(boolean b) {
		WorkerService.isLogged = b;
	}
		
	public static boolean isLogged() {
		return isLogged;
	}
	
	public boolean loginWorker(String password, String id) throws ClassNotFoundException, SQLException {
		
		WorkerDao worker = new WorkerDao();
		
		if(worker.checkLogin(password, id)) {
			return true;
		}
		
		return false;
		
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
	
	public void listWorkerTasks(String id, PrintWriter out) throws ClassNotFoundException, SQLException {
		
		WorkerDao worker = new WorkerDao();
		@SuppressWarnings("unused")
		String idTask = "";
		worker.listWorkerTasks(id);
		ResultSet taskSet = worker.listWorkerTasks(id); //tworzymy tablice z projektami
		ResultSetMetaData col = taskSet.getMetaData();
		int colInt = col.getColumnCount();//pobieramy liczbe kolumn
		
		out.println(stylingMethod());
		
		out.println("<table align='center' border=\"1\">");
		
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
		
		while(taskSet.next()) {
			
			idTask = taskSet.getObject(1).toString();
			
			out.println("<tr>");
			
			for (int i=1; i <= colInt; i++) 
    	    {
    	        Object value = taskSet.getObject(i);
    	        out.println("<td>");
    	        
    	        if (value != null) 
    	        {
    	            out.println(value.toString());
    	            
    	        }
    	        
    	        out.println("</td>");
    	        
    	    }
			
			out.println("<td>");//dodany button z taskami
			out.println("<form action='http://localhost:8080/ProjectManagment/FinishTaskServlet'>");
			out.println("<button value='"+idTask+"' name='task_button' type='submit'>Finish task</button>");
			out.println("</form>");
			out.println("</td>");
						
			out.println("</tr>");
		
		}
					
			out.println("</table>");			
			
			out.println("<br><br>");
			
			out.println("<form action='http://localhost:8080/ProjectManagment/JspFiles/workerView.jsp'>");
			out.println("<button  name='menu_button'type='submit'>back to menu</button>");
			out.println("</form>");
	}
		

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		WorkerService.loginId = loginId;
	}
	
	public String setRealFinish(String taskId) throws SQLException, ClassNotFoundException {//metoda liczy czas trwania wykonania tasku
		
		WorkerDao worker = new WorkerDao();
		String taskStart = worker.getTaskStartDate(taskId);
		
		LocalDate localDateTime = LocalDate.now();
		LocalDate taskStartTime = LocalDate.parse(taskStart);
		
		Period period = Period.between(taskStartTime, localDateTime);			
		
		String result = period.getDays()+"";
		
		return result;			
		
	}
	
	public String setRealTaskDate(String taskId) throws SQLException, ClassNotFoundException {//metoda liczy czas wykonania tasku
		
		WorkerDao worker = new WorkerDao();
		
		System.out.println(worker.getTaskStartDate(taskId));
		
		String taskStart = worker.getTaskStartDate(taskId);
				
		LocalDate taskStartTime = LocalDate.parse(taskStart);
		LocalDate resultDate = taskStartTime.plusDays(Integer.parseInt(setRealFinish(taskId)));
		
		String result = resultDate.toString();
		System.out.println(resultDate);
		
		return result;		
		
	}
	
}
