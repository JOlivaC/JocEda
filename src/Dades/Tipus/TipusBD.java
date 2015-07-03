package Dades.Tipus;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Dades.Claus.PrimaryKey;

public abstract class TipusBD {
	public abstract void Llegir(ResultSet rs) throws SQLException;
	public abstract void Escriure(PreparedStatement ps) throws SQLException;
	public abstract PrimaryKey getPK();
}
