package Dades.Tipus;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Resultat extends PartidaJugador{
	private int Posicio;
	private int Puntuacio;
	
	public Resultat(int iDPartida, String nomJugador, int posicio, int puntuacio) {
		super(iDPartida,nomJugador);
		Posicio = posicio;
		Puntuacio = puntuacio;
	}
	public Resultat(){}
	
	
	
	public int getPosicio() {
		return Posicio;
	}
	public void setPosicio(int posicio) {
		Posicio = posicio;
	}
	public int getPuntuacio() {
		return Puntuacio;
	}
	public void setPuntuacio(int puntuacio) {
		Puntuacio = puntuacio;
	}
	
	public void Llegir(ResultSet rs) throws SQLException{
		super.Llegir(rs);
		Posicio = rs.getInt(3);
		Puntuacio = rs.getInt(4);
	}
	public void Escriure(PreparedStatement ps) throws SQLException{
		super.Escriure(ps);
		ps.setInt(1,Posicio);
	    ps.setInt(2,Puntuacio);
	}

	

}
