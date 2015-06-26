package Domini.LectorResultat;

import java.util.Comparator;

public class InfoJugador {
    private String nom;
    private int puntuacio;

    public InfoJugador(String n, int p){
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

    public static Comparator<InfoJugador> PUNTUACIO = new Comparator<InfoJugador>() {
        @Override
        public int compare(InfoJugador o1, InfoJugador o2) {
            return Integer.valueOf(o2.puntuacio).compareTo(o1.puntuacio);
        }
    };
}
