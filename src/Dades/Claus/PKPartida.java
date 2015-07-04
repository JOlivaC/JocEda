package Dades.Claus;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PKPartida extends PrimaryKey {
	private int IDPartida;
	public PKPartida(int iDPartida) {
		IDPartida = iDPartida;
	}

	@Override
	public void EscriurePK(PreparedStatement ps) throws SQLException {
		ps.setInt(1, IDPartida);
	}

}
