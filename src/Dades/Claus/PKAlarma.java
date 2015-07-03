package Dades.Claus;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PKAlarma extends PrimaryKey {
	public PKAlarma(int iDPartida) {
		super();
		IDPartida = iDPartida;
	}

	private int IDPartida;

	@Override
	public void EscriurePK(PreparedStatement ps) throws SQLException {
		ps.setInt(1, IDPartida);
		
	}
}
