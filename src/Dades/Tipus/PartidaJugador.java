package Dades.Tipus;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class PartidaJugador extends TipusBD {
	private int IDPartida;
	private String nomJugador;
	
	public PartidaJugador(int iDPartida, String nomJugador) {
		IDPartida = iDPartida;
		this.nomJugador = nomJugador;
	}
	public PartidaJugador(){}
	public int getIDPartida() {
		return IDPartida;
	}
	public void setIDPartida(int iDPartida) {
		IDPartida = iDPartida;
	}
	public String getNomJugador() {
		return nomJugador;
	}
	public void setNomJugador(String nomJugador) {
		this.nomJugador = nomJugador;
	}
	
	
	public void Llegir(ResultSet rs) throws SQLException{
		IDPartida = rs.getInt(1);
		nomJugador = rs.getString(2);
	}
	public void Escriure(PreparedStatement ps) throws SQLException{
		ps.setInt(1,IDPartida);
	    ps.setString(2,nomJugador);
	}
	
	
	
}
