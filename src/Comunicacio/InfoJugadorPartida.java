package Comunicacio;

import java.util.Comparator;

public class InfoJugadorPartida {
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

    public static Comparator<InfoJugadorPartida> PUNTUACIO = new Comparator<InfoJugadorPartida>() {
        @Override
        public int compare(InfoJugadorPartida o1, InfoJugadorPartida o2) {
            return Integer.valueOf(o2.puntuacio).compareTo(o1.puntuacio);
        }
    };
}
