package Dades.Acces;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import Dades.Tipus.Jugador;

public class AccesJugador extends AccesClauPrimariaUnica {
	public static String tableName = "jugador";
	
	public static String[] ColumnNames = {"nom",AccesFitxer.PKIdentifier};
	public static String[] ColumnTypes = {"VARCHAR(255)",AccesFitxer.PKType};

	public static String PKIdentifier = ColumnNames[0];
	public static String PKType = ColumnTypes[0];
	
	public static String[] Constraints = {"PRIMARY KEY (" + PKIdentifier + ")",
											"FOREIGN KEY (" + ColumnNames[1] + ") REFERENCES " + AccesFitxer.tableName + "(" + AccesFitxer.PKIdentifier + ")"};
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
	
	private static Jugador Llegir(ResultSet rs) throws SQLException{
		return new Jugador(rs.getString(1),rs.getString(2),rs.getString(3));
	}
	private static void Escriure(PreparedStatement ps,Jugador j) throws SQLException{
		ps.setString(1,j.getNom());
	    ps.setString(2, j.getNomFitxer());
	    ps.setString(3, j.getNomUsuari());
	}
	
	public void Insert(Jugador j) throws Exception {          
        PreparedStatement ps = con.prepareStatement("INSERT INTO " + getTableName() + " VALUES (?,?,?)");
        Escriure(ps,j);
        ps.executeUpdate();
        ps.close();
	}
	
	public  Set<Jugador> getAll() throws Exception {
		Set<Jugador> ret = new HashSet<>();
		ResultSet rs;
		rs = con.createStatement().executeQuery("SELECT * FROM " + getTableName());
		while (rs.next()) ret.add(Llegir(rs));	
		return ret;
	}
	
	public Jugador get(String nom) throws Exception {		
		ResultSet rs;
		PreparedStatement ps = con.prepareStatement("SELECT FROM " + getTableName() + " WHERE " + PKIdentifier + " = ?");
		ps.setString(1, nom);
		rs = ps.executeQuery();	
		return Llegir(rs);
	}

}
