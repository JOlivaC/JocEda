package Dades.Claus;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class PrimaryKey {
	
	public abstract void EscriurePK(PreparedStatement ps) throws SQLException;
}
