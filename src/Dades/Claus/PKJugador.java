package Dades.Claus;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PKJugador extends PrimaryKey{
	private String nom;
	public PKJugador(String nom){this.nom = nom;}
	
	@Override
	public void EscriurePK(PreparedStatement ps) throws SQLException {
		ps.setString(1, nom);	
	}

}
