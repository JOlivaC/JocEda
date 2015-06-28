package Comunicacio;

import java.util.Comparator;

public class InfoJugadorPartida extends Tipus implements Comparable {
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
