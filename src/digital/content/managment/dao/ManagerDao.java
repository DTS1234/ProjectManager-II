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
			
	//		System.out.println("INSERT INTO projects (manager_id, project_id, project_name)" +
	//			"VALUES ( "+projectId+", "+managerId+", "+projectName+");");
			getStmt().executeUpdate("INSERT INTO projects (project_id, manager_id, project_name)" +
					"VALUES ( "+projectId+", "+managerId+", '"+projectName+"');");
			
		}
	
	public void createTask(String taskId, String taskName, String projectId, String plannedDeadline, String taskStart, String taskDependency) throws SQLException {
		
		//System.out.println("INSERT INTO tasks (task_id, project_id, task_name, planned_task_deadline, task_start_date)" +
		//		"VALUES ( "+taskId+", "+projectId+", '"+taskName+"', '"+plannedDeadline+"');");
		getStmt().executeUpdate("INSERT INTO tasks (task_id, project_id, task_name, planned_task_deadline, task_start_date, task_dependency)" +
				"VALUES ( "+taskId+", "+projectId+", '"+taskName+"', '"+plannedDeadline+"', '"+taskStart+"', '"+taskDependency+"');");		
	}
	
	public void addWorkerToTask(String taskId, String workerId) throws SQLException {
		System.out.println("INSERT INTO workerstasks (worker_id, taks_id) VALUES ("+workerId+", "+taskId+");");
		getStmt().executeUpdate("INSERT INTO workerstasks (worker_id, taks_id) VALUES ("+workerId+", "+taskId+");");
	}
	
	public ResultSet printWorkersAndTasks(String projectId) throws SQLException {
		
		System.out.println("SELECT task_id, task_name, project_id, w.worker_id, worker_name from tasks as t, workerstasks as m, \r\n" + 
				"workers as w where w.worker_id = m.worker_id AND t.task_id = m.taks_id and project_id = "+projectId+";");
		
		ResultSet query = getStmt().executeQuery("SELECT ws.worker_id, worker_name, taks_id, t.task_name FROM workerstasks as ws INNER JOIN workers as w ON w.worker_id = ws.worker_id "
				+ "INNER JOIN tasks as t on t.task_id = taks_id WHERE t.project_id = "+projectId+";");
		
		return query;
	}
	
	public ResultSet printAvailabaleWorkers(String projectId) throws SQLException {
		
		ResultSet query = getStmt().executeQuery("SELECT m.worker_name, m.worker_id from workers as m, projects as p where m.worker_id NOT IN (Select worker_id from workerstasks) AND project_id = "+projectId+";");
		
		return query;
	}
	
	public ResultSet createAvaialalbleWorkers(String projectId) throws SQLException {
		
		ResultSet query = getStmt().executeQuery("SELECT m.worker_name, m.worker_id from workers as m, projects as p where m.worker_id NOT IN (Select worker_id from workerstasks) AND project_id = "+projectId+";");
		
		return query;
	}
	
	public ResultSet checkIfTasksAreDone(String projectId) throws SQLException {
		
	
		ResultSet query = getStmt().executeQuery("SELECT task_id, task_name, project_id, w.worker_id, worker_name from tasks as t, workerstasks as m, \r\n" + 
				"workers as w where w.worker_id = m.worker_id AND t.task_id = m.taks_id and project_id = "+projectId+" and t.task_duration IS NULL;");
		
		return query;
		
	}
	
	public String getIdString(String id, String table, String name, String searchedName) throws SQLException {
		
		String tDid = "";
		ResultSet query = findId(id, table, name, searchedName);
		
		while(query.next()) {
			tDid = query.getObject(1).toString();
		}
		
		return tDid;
	}
	
	public String getTaskDuration(String taskName) throws SQLException {
		System.out.println("SELECT task_duration from tasks where task_name = '"+taskName+"';");
		ResultSet query = getStmt().executeQuery("SELECT task_duration from tasks where task_name = '"+taskName+"';");
		String taskDurationString = "";
		while(query.next()) {
			taskDurationString = query.getString(1);
		}
		return taskDurationString;
	}
	
	public boolean checkIfTasksIsDone(String task_id) throws SQLException {
		//System.err.println("SELECT task_dependency, task_id, task_name, project_id, w.worker_id, worker_name from tasks as t, workerstasks as m, \r\n" + 
		//		"workers as w where w.worker_id = m.worker_id AND t.task_id = m.taks_id and task_id = "+task_id+" and t.task_duration IS NULL and task_dependency != 'no dependency';");
		System.out.println(task_id);
		ResultSet query = getStmt().executeQuery("SELECT task_dependency, task_id, task_duration from tasks as t, workerstasks as m, \r\n" + 
				"workers as w where w.worker_id = m.worker_id AND t.task_id = m.taks_id and task_id = "+task_id+" and t.task_duration IS NULL and task_dependency != 'no dependency';");
		String taskDependency = "";
		while(query.next()) {
			taskDependency = query.getString(1);
		}
		
		query.previous();
		query.previous();
		
		if(!query.next()) {
			System.out.println("true!!!");
			return true;
		}else{
			System.out.println(getTaskDuration("task_1"));
			System.out.println();
			System.out.println(getTaskDuration(taskDependency)+"!!!");
			if(getTaskDuration(taskDependency)==null) {
				return false;
			}
			
			if(taskDependency.equals("no dependecy")) {//literówka !!!
				System.out.println("true!!!");
				return true;
			}else{
				return checkIfTasksIsDone(getIdString("task_id", "tasks", "task_name", taskDependency));
				}		
			}		
		}
	
	public void deleteAssignments(String projectId) throws SQLException {
		
		getStmt().execute("SET FOREIGN_KEY_CHECKS=0;");
		getStmt().executeUpdate("DELETE ws, t FROM workerstasks as ws INNER JOIN workers as w ON w.worker_id = ws.worker_id\r\n" + 
				"INNER JOIN tasks as t on t.task_id = taks_id where t.project_id ="+projectId+" ;");
		getStmt().execute("SET FOREIGN_KEY_CHECKS=1;");
		
	}
	
	public ResultSet createTaskTable(String projectId) throws SQLException {
		
		ResultSet query = getStmt().executeQuery("SELECT task_name from tasks where project_id = "+projectId+" AND task_id NOT IN (SELECT taks_id from workerstasks where taks_id = task_id);");
		
		return query;
		
	}
	
	public ResultSet createTaskTable2() throws SQLException {
		
		ResultSet query = getStmt().executeQuery("SELECT task_name from tasks;");
		
		return query;
		
	}
	
	public ResultSet createProjectsTable(String managerId) throws SQLException {
		
		ResultSet query = getStmt().executeQuery("SELECT project_name FROM projects WHERE manager_id= "+managerId+";");
		
		return query;
	}
	
	public ResultSet taksDependencySet(String taskId) throws SQLException {
		
		ResultSet query = getStmt().executeQuery("SELECT task_dependency FROM tasks where task_id = "+taskId+";");
		
		return query;
	}
}
