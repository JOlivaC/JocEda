package Comunicacio;

public class InfoJugadorPosicio extends Tipus implements Comparable {
	 private String nom;
	 private int Punts;
	
	 
	 @Override
	public int compareTo(Object o) {
		return Integer.compare(((InfoJugadorPosicio) o).Punts,Punts);
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public int getPunts() {
		return Punts;
	}


	public void setPunts(int punts) {
		Punts = punts;
	}
}
