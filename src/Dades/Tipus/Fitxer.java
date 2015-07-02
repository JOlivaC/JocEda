package Dades.Tipus;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
		// TODO Auto-generated method stub
		
	}
	@Override
	public void Escriure(PreparedStatement ps) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	
}
