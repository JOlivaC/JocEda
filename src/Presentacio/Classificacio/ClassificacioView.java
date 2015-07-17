package Presentacio.Classificacio;

import java.awt.event.ActionListener;
import java.util.SortedSet;

import Comunicacio.InfoJugadorRanking;
import Presentacio.Comuns.PanellGeneral;
import Presentacio.Taula.Taula;

public class ClassificacioView extends PanellGeneral{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Taula t;
	public ClassificacioView(ActionListener Retrocedir,SortedSet<InfoJugadorRanking> info){
		super(Retrocedir);
		t = new Taula("Classificacio", getHeaders(4));
		AfegirInfoTaula(info);
		this.add(t);
	}
	
	private static String[] getHeaders(int n){
		String[] ret = new String[2 + n];
		ret[0] = "Jugador";
		ret[1] = "Punts";
		for (int k = 0;k < n; k++){
			ret[2 + k] = "Cops: " + String.valueOf(k+1);
		}
		return ret;
	}
	
	private void AfegirInfoTaula(SortedSet<InfoJugadorRanking> info){
		for (InfoJugadorRanking i : info){
			String[] rows = new String[6];
			rows[0] = i.getPos().getNom();
			rows[1] = String.valueOf(i.getPos().getPunts());
			for (int x :i.getN().getPosicions().keySet()){
				rows[1 + x] = String.valueOf(i.getN().getPosicions().get(x));
			}
			t.Insereix(rows);
		}
	}

}
