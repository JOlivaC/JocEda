package Dades.Acces;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import Dades.Controladors.TaulaPartida;
import Dades.Factories.ConnexioBD;
import Dades.Tipus.Alarma;

public class AccesAlarma extends AccesClauPrimariaUnica {
	public static String tableName = "alarma";
	
	public static String[] ColumnNames = {"IDPartida","data"};
	public static String[] ColumnTypes = {"INTEGER","TIMESTAMP"};

	public static String PKIdentifier = ColumnNames[0];
	public static String PKType = ColumnTypes[0];
	
	public static String[] Constraints = {"PRIMARY KEY (" + PKIdentifier + ")",
											"FOREIGN KEY (" + PKIdentifier + ") REFERENCES " + TaulaPartida.TableName};
	
	@Override
	public  String getPKIdentifier() {
		return PKIdentifier;
	}
	@Override
	public  String getPKType() {
		return PKType;
	}
	@Override
	protected String[] getColumnNames() {
		return ColumnNames;
	}

	@Override
	protected String[] getColumnTypes() {
		// TODO Auto-generated method stub
		return ColumnTypes;
	}

	@Override
	protected String[] getConstraints() {
		// TODO Auto-generated method stub
		return Constraints;
	}

	@Override
	protected String getTableName() {
		// TODO Auto-generated method stub
		return tableName;
	}
	
	private static Alarma Llegir(ResultSet rs) throws SQLException{
		return new Alarma(rs.getInt(1),new Date(rs.getTimestamp(2).getTime()));
	}
	private static void Escriure(PreparedStatement ps,Alarma a) throws SQLException{
		java.sql.Timestamp sqlInstant = new java.sql.Timestamp(a.getData().getTime());
		ps.setInt(1, a.getIDPartida());
	    ps.setTimestamp(2, sqlInstant);
	}
	
	public void Insert(Alarma a) throws Exception {          
        PreparedStatement ps = con.prepareStatement("INSERT INTO " + getTableName() + " VALUES (?,?)");
        Escriure(ps,a);
        ps.executeUpdate();
        ps.close();
	}
	
	public  Set<Alarma> getAll() throws Exception {
		Set<Alarma> ret = new HashSet<>();
		ResultSet rs;
		rs = con.createStatement().executeQuery("SELECT * FROM " + getTableName());
		while (rs.next()) ret.add(Llegir(rs));	
		return ret;
	}
	
	public Alarma get(int IDPartida) throws Exception {		
		ResultSet rs;
		PreparedStatement ps = con.prepareStatement("SELECT FROM " + getTableName() + " WHERE " + ColumnNames[0] + " = ?");
		ps.setInt(1, IDPartida);
		rs = ps.executeQuery();	
		return Llegir(rs);
	}
	
	public  void Delete(Alarma a) throws Exception {
		PreparedStatement ps = con.prepareStatement("DELETE FROM " + getTableName() + " WHERE " + ColumnNames[0] + " = ?");
		ps.setInt(1, a.getIDPartida());
		ps.executeUpdate();
	}
	

	

	
	
				

	
}
