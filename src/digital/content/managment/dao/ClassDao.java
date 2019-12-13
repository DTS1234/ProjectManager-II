package digital.content.managment.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import digital.content.managment.sqlconnector.DbManager;


public class ClassDao {
	
	private Statement stmt;
		
	public ClassDao() throws ClassNotFoundException, SQLException {
		super();
		this.stmt = DbManager.getConnection().createStatement();//pod³aczam byt do bazy danych korzystam z klasy dbmanager z pakietu sqlconnector
	}

	public Statement getStmt() {
		return stmt;
	}

	
	public void delete(String id, String table, String idType) throws SQLException, ClassNotFoundException  {
		
		
		System.out.println("DELETE  FROM " +  table.toString() + " WHERE "+idType+" = "+ id.toString() +";");
		stmt.executeUpdate("DELETE  FROM " +  table.toString() + " WHERE "+idType+" = "+ id.toString() +";" );//usuwa szajs po podanych parametrach
	
	}
	
	public ResultSet createSet(String table) throws SQLException{ //tworzy talblice z sql i przechowuje w zmiennej query
		
		ResultSet query = getStmt().executeQuery("SELECT * FROM "+table+";");
		
		return query;
	}
	
	public ResultSet createUniqueSet(String table, String id, String searchedID) throws SQLException{ //tworzy talblice z sql i przechowuje w zmiennej query
		
		System.out.println("SELECT * FROM "+table+" WHERE "+id+" = "+ searchedID+";" + " bala bala");
		ResultSet query = getStmt().executeQuery("SELECT * FROM "+table+" WHERE "+id+" = "+ searchedID+";");//zmieñ !!!!
		
		return query;
	}
	
	public void createUser(String workerId, String workerName, String workerPassword) throws SQLException {
		
		getStmt().executeUpdate("INSERT INTO workers ( worker_id, worker_name, worker_password )\r\n" + 
				"VALUES ("+workerId+", '"+workerName+"', '"+workerPassword+"') ;");
		
	}
	
	public void createManager(String managerId, String managerName, String managerPassword) throws SQLException {
			
			getStmt().executeUpdate("INSERT INTO managers ( manager_id, manager_name, manager_password )\r\n" + 
					"VALUES ("+managerId+", '"+managerName+"', '"+managerPassword+"') ;");
			
		}

}
