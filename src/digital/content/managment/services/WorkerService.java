package digital.content.managment.services;

import java.sql.SQLException;

import digital.content.managment.dao.WorkerDao;

public class WorkerService {

	private static boolean isLogged = false;
	
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
	
}
