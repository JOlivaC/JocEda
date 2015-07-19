package Comunicacio;

public class InfoJugadorPosicio extends Tipus implements Comparable<Object> {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nom;
	 private int Punts;
	
	 
	 @Override
	public int compareTo(Object o) {
		return -1 * Integer.compare(((InfoJugadorPosicio) o).Punts,Punts);
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
