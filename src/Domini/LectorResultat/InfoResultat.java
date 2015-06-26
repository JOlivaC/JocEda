package Domini.LectorResultat;

import java.util.Collections;
import java.util.Vector;

public class InfoResultat {
	private Vector<InfoJugador> resultat;
        
	public InfoResultat(int n){
		resultat = new Vector<>(n);
	}
	
	public void addInfoJugador(InfoJugador IJ){
		resultat.add(IJ);
	}
        
        public void ordenar(){
            Collections.sort(resultat,InfoJugador.PUNTUACIO);
        }
        
        public String toString(){
            String s = "Resultat: \n";
            for(int i=0; i<resultat.size(); ++i){
                InfoJugador j = resultat.get(i);
                s += (i+1)+". "+j.toString()+"\n";
            }
            return s;
        }
        
}
