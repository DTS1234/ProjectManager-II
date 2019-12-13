package digital.content.managment.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class WorkerDao extends ClassDao{

	public WorkerDao() throws ClassNotFoundException, SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean checkLogin(String password, String id) throws SQLException {
		
		ResultSet queryResultPassword = getStmt().executeQuery("SELECT worker_password FROM workers WHERE worker_id = " + id +";");
		String passwordDb = null;		
		
		while(queryResultPassword.next()) {
			passwordDb = queryResultPassword.getString("worker_password");
		}
		
		ResultSet queryResultId = getStmt().executeQuery("SELECT worker_id FROM workers WHERE worker_id = " + id +";");
		String idDb = null;
						
		while(queryResultId.next()) {
			idDb = queryResultId.getString("worker_id");
		}		
		
		if(idDb==null) {
			return false;
		}
		
		if(passwordDb==null) {
			return false;
		}
		
			if(passwordDb.equals(password) && id.equals(idDb)) {
				return true;
			}
		
		return false;
	}
	
	public ResultSet listWorkerTasks(String workerId) throws SQLException {
		
		System.out.println("select task_id, task_name, m.worker_id, worker_name from workerstasks as m, tasks as t, "
				+ "workers as s " + 
				"where m.worker_id = "+ workerId +" and task_id = taks_id and task_duration IS NULL;");
		
		
		ResultSet query = getStmt().executeQuery("select task_id, task_name, s.worker_id, worker_name from workerstasks as m, tasks as t,"+ 
				"workers as s where m.worker_id = " + workerId + " and m.worker_id = s.worker_id and task_id = taks_id and task_duration IS NULL;");
		
		
		return query;
		
	}
	
	public void finishTask(String taskId, String realTaskDeadline, String taskDuration) throws SQLException {
		
		getStmt().executeUpdate("UPDATE tasks SET real_task_deadline = '"+realTaskDeadline+"', task_duration = '"+ taskDuration +
				"' WHERE task_id = "+taskId+" ;");
		
	}
	
	public String getTaskStartDate(String taskId) throws SQLException {
		
		ResultSet query = getStmt().executeQuery("SELECT task_start_date FROM tasks WHERE task_id = " + taskId +";");
		
		String date = "";
		
		while(query.next()) {
			 date = query.getString("task_start_date");
		}
		
		return date;
		
	}
	
}
