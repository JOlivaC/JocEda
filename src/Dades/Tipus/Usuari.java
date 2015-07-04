package Dades.Tipus;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Dades.Claus.PKUsuari;
import Dades.Claus.PrimaryKey;

public class Usuari extends TipusBD {

	private String user;
	private String pass;
	
	public Usuari(String user, String pass) {
		super();
		this.user = user;
		this.pass = pass;
	}
	public Usuari(){}

	
	@Override
	public void Llegir(ResultSet rs) throws SQLException {
		this.setUser(rs.getString(1));
		this.setPass(rs.getString(2));
	}

	@Override
	public void Escriure(PreparedStatement ps) throws SQLException {
		ps.setString(1, this.getUser());
		ps.setString(2, this.getPass());
	}

	@Override
	public PrimaryKey getPK() {
		return new PKUsuari(this.getPass());
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}
