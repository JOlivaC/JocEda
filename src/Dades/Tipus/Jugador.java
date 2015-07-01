package Dades.Tipus;

public class Jugador {
	
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
}
