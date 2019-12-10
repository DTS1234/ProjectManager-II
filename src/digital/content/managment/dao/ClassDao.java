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

	public Object findById(String id, String table, String idType) throws SQLException, ClassNotFoundException  {
		
			ResultSet queryResult = stmt.executeQuery("SELECT "+id.toString()+" FROM " + table.toString() + " WHERE " + idType.toString() + " = " + id +";");
			Object value = queryResult.getObject(1);		
		
		return value;
	}
	
	public void delete(String id, String table, String idType) throws SQLException, ClassNotFoundException  {
		
		stmt.executeQuery(" DELETE FROM " +  table.toString() + " WHERE = " + id.toString() +";" );//usuwa szajs po podanych parametrach
	
	}
	
	public ResultSet createSet(String table) throws SQLException{ //tworzy talblice z sql i przechowuje w zmiennej query
		
		ResultSet query = getStmt().executeQuery("SELECT * FROM "+table+";");
		
		return query;
	}
	
	public ResultSet createUniqueSet(String table, String id, String searchedID) throws SQLException{ //tworzy talblice z sql i przechowuje w zmiennej query
		
		ResultSet query = getStmt().executeQuery("SELECT * FROM "+table+" WHERE "+id+" >= "+ searchedID+";");//zmieñ !!!!
		
		return query;
	}
	
	
	
	
	
}
