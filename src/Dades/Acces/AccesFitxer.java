package Dades.Acces;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import Dades.Controladors.TaulaPartida;
import Dades.Tipus.Alarma;
import Dades.Tipus.Fitxer;

public class AccesFitxer extends AccesClauPrimariaUnica {
	public static String tableName = "fitxer";
	
	public static String[] ColumnNames = {"Nom","Dades"};
	public static String[] ColumnTypes = {"VARCHAR(255)","BYTEA"};

	public static String PKIdentifier = ColumnNames[0];
	public static String PKType = ColumnTypes[0];
	
	public static String[] Constraints = {"PRIMARY KEY (" + PKIdentifier + ")"};
	

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
	
	private static Fitxer Llegir(ResultSet rs) throws SQLException{
		return new Fitxer(rs.getString(1),rs.getBytes(2));
	}
	private static void Escriure(PreparedStatement ps,Fitxer f) throws SQLException{
		ps.setString(1, f.getNom());
	    ps.setBytes(2, f.getDades());
	}
	
	public void Insert(Fitxer f) throws Exception {          
        PreparedStatement ps = con.prepareStatement("INSERT INTO " + getTableName() + " VALUES (?,?)");
        Escriure(ps,f);
        ps.executeUpdate();
        ps.close();
	}
	
	public void Update(Fitxer f) throws Exception {          
        PreparedStatement ps = con.prepareStatement("UPDATE " + getTableName() + " WHERE " + ColumnNames[1] + " = ? SET " + ColumnNames[2] + " = ?");
        Escriure(ps,f);
        ps.executeUpdate();
        ps.close();
	}
	
	public Fitxer get(String nom) throws Exception {		
		ResultSet rs;
		PreparedStatement ps = con.prepareStatement("SELECT FROM " + getTableName() + " WHERE " + PKIdentifier + " = ?");
		ps.setString(1, nom);
		rs = ps.executeQuery();	
		return Llegir(rs);
	}
	
	public  void Delete(Fitxer f) throws Exception {
		PreparedStatement ps = con.prepareStatement("DELETE FROM " + getTableName() + " WHERE " + PKIdentifier + " = ?");
		ps.setString(1, f.getNom());
		ps.executeUpdate();
	}
}
