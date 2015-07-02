package Dades.Acces;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Dades.Tipus.Alarma;

public abstract class AccesClauPrimariaUnica extends Acces {
	public abstract String getPKIdentifier();
	public abstract String getPKType();
	
	public Alarma get(int IDPartida) throws Exception {		
		ResultSet rs;
		PreparedStatement ps = con.prepareStatement("SELECT FROM " + getTableName() + " WHERE " + ColumnNames[0] + " = ?");
		ps.setInt(1, IDPartida);
		rs = ps.executeQuery();	
		return Llegir(rs);
	}
}
