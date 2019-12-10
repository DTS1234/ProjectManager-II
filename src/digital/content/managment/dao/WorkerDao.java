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
	
}
