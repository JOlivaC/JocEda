package Comunicacio;

public class InfoJugadorPartida extends Tipus implements Comparable<Object> {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nom;
    private int puntuacio;

    public InfoJugadorPartida(String n, int p){
        nom = n;
        puntuacio = p;
    }

    public String getNom(){
        return nom;
    }

    public int getPuntuacio(){
        return puntuacio;
    }

    public String toString(){
            return nom + ": " + String.valueOf(puntuacio);
    }
    
    public int compareTo(Object o){
    	return Integer.compare(((InfoJugadorPartida)o).puntuacio,this.puntuacio);
    }

}
