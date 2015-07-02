package Dades.Tipus;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Partida extends TipusBD {
	private int IDPartida;
	private String fitxer;
	private int Estat;
	public Partida(){}
	public Partida(int IDPartida,String fitxer,int Estat){this.IDPartida = IDPartida;this.fitxer = fitxer;this.Estat = Estat;}
	public int getIDPartida() {
		return IDPartida;
	}
	public void setIDPartida(int iDPartida) {
		IDPartida = iDPartida;
	}
	public String getFitxer() {
		return fitxer;
	}
	public void setFitxer(String fitxer) {
		this.fitxer = fitxer;
	}
	public int getEstat() {
		return Estat;
	}
	public void setEstat(int estat) {
		Estat = estat;
	}
	@Override
	public void Llegir(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void Escriure(PreparedStatement ps) throws SQLException {
		// TODO Auto-generated method stub
		
	}
}
