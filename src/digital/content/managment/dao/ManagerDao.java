package digital.content.managment.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ManagerDao extends ClassDao {

	public ManagerDao() throws ClassNotFoundException, SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	//klasa dziedziczy po ClassDao, metody dzia³aj¹ podobnie ale dotycz¹ tylko funkcjonalnosci manger'a
	public boolean checkLogin(String password, String id) throws SQLException {
				
		ResultSet queryResultPassword = getStmt().executeQuery("SELECT manager_password FROM managers WHERE manager_id = " + id +";");
		String passwordDb = null;
		
		while(queryResultPassword.next()) {
			passwordDb = queryResultPassword.getString("manager_password");
		}
		
		ResultSet queryResultId = getStmt().executeQuery("SELECT manager_id FROM managers WHERE manager_id = " + id +";");
		String idDb = null;
		
		while(queryResultId.next()) {
			idDb = queryResultId.getString("manager_id");
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
	
	public void createProject(String projectName, String projectId, String managerId) throws SQLException {
			
			System.out.println("INSERT INTO projects (manager_id, project_id, project_name)" +
				"VALUES ( "+projectId+", "+managerId+", "+projectName+");");
			getStmt().executeUpdate("INSERT INTO projects (project_id, manager_id, project_name)" +
					"VALUES ( "+projectId+", "+managerId+", '"+projectName+"');");
			
		}
	
	public void createTask(String taskId, String taskName, String projectId, String plannedDeadline) throws SQLException {
		
		System.out.println("INSERT INTO tasks (task_id, project_id, task_name, planned_task_deadline)" +
				"VALUES ( "+taskId+", "+projectId+", '"+taskName+"', '"+plannedDeadline+"');");
		getStmt().executeUpdate("INSERT INTO tasks (task_id, project_id, task_name, planned_task_deadline)" +
				"VALUES ( "+taskId+", "+projectId+", '"+taskName+"', '"+plannedDeadline+"');");
		
	}
	
	public void addWorkerToTask(String taskId, String workerId) throws SQLException {
		getStmt().executeUpdate("INSERT INTO workerstasks (worker_id, taks_id) VALUES ("+workerId+", "+taskId+");");
	}
	
	public ResultSet printWorkersAndTasks() throws SQLException {
		
		ResultSet query = getStmt().executeQuery("select task_id, task_name, m.worker_id, worker_name from workerstasks as m, tasks, workers as s " + 
				"where m.worker_id = s.worker_id and task_id = taks_id;");
		
		return query;
	}
	
}
