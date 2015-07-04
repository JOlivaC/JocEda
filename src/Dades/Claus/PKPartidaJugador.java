package Dades.Claus;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PKPartidaJugador extends PrimaryKey {

	private int IDPartida;
	private String nomJugador;
	
	public PKPartidaJugador(int iDPartida, String nomJugador) {
		super();
		IDPartida = iDPartida;
		this.nomJugador = nomJugador;
	}

	@Override
	public void EscriurePK(PreparedStatement ps) throws SQLException {
		ps.setInt(1, IDPartida);
		ps.setString(2, nomJugador);
		
	}

}
