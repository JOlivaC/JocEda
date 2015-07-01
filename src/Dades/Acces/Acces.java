package Dades.Acces;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class Acces {
	
	protected abstract String[] getColumnNames();
	protected abstract String[] getColumnTypes();
	protected abstract String[] getConstraints();
	protected abstract String getTableName();
	protected Connection con;
	
	public void setConnection(Connection con){this.con = con;}
	public void closeconnection() throws SQLException{con.close();}
	
	public void CreateTable() throws Exception{
		String statement = "CREATE TABLE " + 
				getTableName() + " (" +
				getColumnsDefinition() +
				getConstraintsDefinition() +	
				");";
		con.createStatement().executeUpdate(statement);		
	}
	private  String getColumnsDefinition(){
		String ret = "";
		String[] ColumnNames = getColumnNames();
		String[] ColumnTypes = getColumnTypes();
		for (int i = 0; i < ColumnNames.length; i++){
			ret += ColumnNames[i] + " " + ColumnTypes[i] + ", ";
		}
		return ret;
	}
	
	
	private  String getConstraintsDefinition(){
		String ret = "";
		String[] Constraints = getConstraints();
		for (int i = 0; i < Constraints.length; i++){
			ret += Constraints[i];
			if (i < Constraints.length - 1) ret += ", ";
		}
		return ret;
	}
	
	
	public boolean TableExists() throws Exception{
		DatabaseMetaData meta = con.getMetaData();
	    ResultSet rs = meta.getTables(null,null,getTableName().toLowerCase(),null);
		return rs.next();
		
	}
	public void DropTable() throws Exception{
		con.createStatement().executeUpdate("DROP TABLE " + getTableName());
	}

	public void DeleteAll() throws Exception{
		 con.createStatement().executeUpdate("TRUNCATE TABLE " + getTableName());
	}
	
}
