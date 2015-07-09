package Domini.LectorResultat;

import java.util.Collections;
import java.util.Vector;

import Comunicacio.InfoJugadorPartida;

public class InfoResultat {
    private Vector<InfoJugadorPartida> resultat;

    public InfoResultat(int n){
            resultat = new Vector<>(n);
    }

    public void addInfoJugador(InfoJugadorPartida IJ){
            resultat.add(IJ);
    }

    public void ordenar(){
        Collections.sort(resultat);
    }
    
    public Vector<InfoJugadorPartida> getResultat(){return resultat;}

    public String toString(){
        String s = "Resultat: \n";
        for(int i=0; i<resultat.size(); ++i){
            InfoJugadorPartida j = resultat.get(i);
            s += (i+1)+". "+j.toString()+"\n";
        }
        return s;
    }
    
}
