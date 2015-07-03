package Dades.Tipus;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Dades.Claus.PKFitxer;
import Dades.Claus.PrimaryKey;

public class Fitxer extends TipusBD{
	private String nom;
	private byte[] dades;
	public Fitxer(){
		
	}
	public Fitxer(String nom,byte[] dades){this.nom = nom;this.dades = dades;}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public byte[] getDades() {
		return dades;
	}
	public void setDades(byte[] dades) {
		this.dades = dades;
	}
	@Override
	public void Llegir(ResultSet rs) throws SQLException {
		setNom(rs.getString(1));
		setDades(rs.getBytes(2));
		
	}
	@Override
	public void Escriure(PreparedStatement ps) throws SQLException {
		ps.setString(1, getNom());
		ps.setBytes(2, getDades());
	}
	@Override
	public PrimaryKey getPK() {
		return new PKFitxer(getNom());
	}
	
}
