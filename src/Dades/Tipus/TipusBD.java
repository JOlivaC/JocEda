package Dades.Tipus;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class TipusBD {
	public abstract void Llegir(ResultSet rs) throws SQLException;
	public abstract void Escriure(PreparedStatement ps) throws SQLException;
}
