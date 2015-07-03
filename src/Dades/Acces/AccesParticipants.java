package Dades.Acces;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import Dades.Tipus.Alarma;
import Dades.Tipus.Participants;
import Dades.Tipus.Partida;
import Dades.Tipus.TipusBD;

public class AccesParticipants extends AccesPartidaJugador {
	public static String tableName = "participants";

	@Override
	protected String getTableName() {
		// TODO Auto-generated method stub
		return tableName;
	}

	@Override
	protected TipusBD LlegirResultat(ResultSet rs) throws SQLException {
		Participants ret = new Participants();
		ret.Llegir(rs);
		return ret;
	}




}
