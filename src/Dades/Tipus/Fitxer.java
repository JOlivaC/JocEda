package Dades.Tipus;

public class Fitxer {
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
	
}
