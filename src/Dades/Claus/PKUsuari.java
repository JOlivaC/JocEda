package Dades.Claus;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PKUsuari extends PrimaryKey {
	private String user;
	public PKUsuari(String user){this.user = user;}
	@Override
	public void EscriurePK(PreparedStatement ps) throws SQLException {
		ps.setString(1, user);
	}

}
