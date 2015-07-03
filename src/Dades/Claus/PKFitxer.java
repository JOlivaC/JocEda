package Dades.Claus;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PKFitxer extends PrimaryKey {
	private String nom;

	public PKFitxer(String nom){this.nom = nom;}
	@Override
	public void EscriurePK(PreparedStatement ps) throws SQLException {
		ps.setString(1, nom);
	}
	
}
