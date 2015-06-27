package Presentacio.Classificacio;

import java.awt.event.ActionListener;

import Presentacio.Comuns.PanellGeneral;
import Presentacio.Taula.Taula;

public class ClassificacioView extends PanellGeneral{
	private Taula t;
	public ClassificacioView(ActionListener Retrocedir,int n){
		super(Retrocedir);
		t = new Taula("Classificacio", getHeaders(n));
		this.add(t);
	}
	
	private static String[] getHeaders(int n){
		String[] ret = new String[2 + n];
		ret[0] = "Jugador";
		ret[1] = "Punts";
		for (int k = 0;k < n; k++){
			ret[2 + k] = "Nº" + String.valueOf(k+1);
		}
		return ret;
	}

}
