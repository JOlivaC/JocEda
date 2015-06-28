package Comunicacio;

public class InfoJugadorPosicio extends Tipus implements Comparable {
	 private String nom;
	 private int Punts;
	
	 
	 @Override
	public int compareTo(Object o) {
		return Integer.compare(((InfoJugadorPosicio) o).Punts,Punts);
	}
}
