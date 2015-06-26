package Domini.LectorResultat;

import java.util.Vector;

public class InfoResultat {
	private Vector<InfoJugador> resultat;
	
	public InfoResultat(int n){
		resultat = new Vector<>(n);
	}
	
	public void SetPosicio(int i,InfoJugador IJ){
		resultat.set(i,IJ);
	}
}
