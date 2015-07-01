package Dades.Controladors;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import Actors.Alarmes.AlarmaJugar;
import Dades.Connexio.ConnexioBD;
import Domini.InterficieBD.CtrlAlarma;

public class TaulaAlarma implements CtrlAlarma {

	public static String tableName = "alarma";
	
	public static String[] ColumnNames = {"IDPartida","data"};
	public static String[] ColumnTypes = {"INTEGER","TIMESTAMP"};

	public static String[] Constraints = {"PRIMARY KEY (" + ColumnNames[0] + ")",
											"FOREIGN KEY (" + ColumnNames[0] + ") REFERENCES " + TaulaPartida.TableName};
	
	

	public static void CreateTable(Connection con) throws Exception{
		String statement = "CREATE TABLE " + 
				tableName + " (" +
				getColumnsDefinition() +
				getConstraints() +	
				");";
		con.createStatement().executeUpdate(statement);		
	}
	private static String getColumnsDefinition(){
		String ret = "";
		for (int i = 0; i < ColumnNames.length; i++){
			ret += ColumnNames[i] + " " + ColumnTypes[i] + ", ";
		}
		return ret;
	}
	private static String getConstraints(){
		String ret = "";
		for (int i = 0; i < Constraints.length; i++){
			ret += Constraints[i];
			if (i < Constraints.length - 1) ret += ", ";
		}
		return ret;
	}
	
	
	public static boolean TableExists(Connection con) throws Exception{
		DatabaseMetaData meta = con.getMetaData();
	    ResultSet rs = meta.getTables(null,null,tableName.toLowerCase(),null);
		return rs.next();
		
	}
	public static void DropTable(Connection con) throws Exception{
		con.createStatement().executeUpdate("DROP TABLE " + tableName);
	}
	@Override
	public void DeleteAll() throws Exception{
		 Connection con = ConnexioBD.getInstance().getConnexio();
		 con.createStatement().executeUpdate("TRUNCATE TABLE " + tableName);
		 con.close();
	}
	public void Create() throws Exception{
		Connection con = ConnexioBD.getInstance().getConnexio();
		CreateTable(con);
		con.close();
	}
	public void Insert(AlarmaJugar a) throws Exception {          
	            Connection con = ConnexioBD.getInstance().getConnexio();
	            PreparedStatement ps = con.prepareStatement("INSERT INTO " + tableName + " VALUES (?,?)");

	            java.sql.Timestamp sqlInstant = new java.sql.Timestamp(a.getData().getTime());
	            ps.setInt(1, a.getIDPartida());
	            ps.setTimestamp(2, sqlInstant);

	            ps.executeUpdate();

	            ps.close();
	            con.close();
	}
	
	@Override
	public Set<AlarmaJugar> getAll() throws Exception {
		Connection con = ConnexioBD.getInstance().getConnexio();
		
		Set<AlarmaJugar> ret = new HashSet<>();
		ResultSet rs;
		rs = con.createStatement().executeQuery("SELECT * FROM " + tableName);

		while (rs.next()){
			AlarmaJugar a = new AlarmaJugar(
					new Date(rs.getTimestamp(2).getTime()),
					rs.getInt(1)				
			);	
			ret.add(a);
		}
		
		con.close();
		return ret;
	}
	@Override
	public void Delete(AlarmaJugar a) throws Exception {
		Connection con = ConnexioBD.getInstance().getConnexio();
		PreparedStatement ps = con.prepareStatement("DELETE FROM " + tableName + " WHERE ID = ?");
		ps.setInt(1, a.getIDPartida());
		ps.executeUpdate();
		con.close();
	}
	
}
