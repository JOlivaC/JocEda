package Dades.Tipus;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Dades.Claus.PKJugador;
import Dades.Claus.PrimaryKey;

public class Jugador extends TipusBD {
	
	private String nom;
	private String nomFitxer;
	private String nomUsuari;
	
	public Jugador(String nom, String nomFitxer, String nomUsuari) {
		this.nom = nom;
		this.nomFitxer = nomFitxer;
		this.nomUsuari = nomUsuari;
	}
	
	public Jugador(){
		
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getNomFitxer() {
		return nomFitxer;
	}

	public void setNomFitxer(String nomFitxer) {
		this.nomFitxer = nomFitxer;
	}

	public String getNomUsuari() {
		return nomUsuari;
	}

	public void setNomUsuari(String nomUsuari) {
		this.nomUsuari = nomUsuari;
	}

	@Override
	public void Llegir(ResultSet rs) throws SQLException {
		this.setNom(rs.getString(1));
		this.setNomFitxer(rs.getString(2));
		this.setNomUsuari(rs.getString(3));
		
	}

	@Override
	public void Escriure(PreparedStatement ps) throws SQLException {
		ps.setString(1, this.getNom());
		ps.setString(2, this.getNomFitxer());
		ps.setString(3, this.getNomUsuari());	
	}

	@Override
	public PrimaryKey getPK() {
		return new PKJugador(this.getNom());
	}
}
