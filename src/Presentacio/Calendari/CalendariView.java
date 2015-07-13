package Presentacio.Calendari;

import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.SortedSet;

import Comunicacio.InfoCalendariPartida;
import Presentacio.Comuns.PanellGeneral;
import Presentacio.Taula.Taula;

public class CalendariView extends PanellGeneral {
	private static String ID = "ID";
	private static String Jugador = "U";
	private static String Data = "Data";
	
	private Taula t;

	
	public CalendariView(ActionListener retrocedir,int n,SortedSet<InfoCalendariPartida> info) {
		super(retrocedir);
		t = new Taula("Calendari",CrearHeaders(n));
		AfegirInfoTaula(info);
		this.add(t);		
	}

	
	private void AfegirInfoTaula(SortedSet<InfoCalendariPartida> info){
		for (InfoCalendariPartida i : info){
			String[] rows = new String[6];
			rows[0] = String.valueOf(i.getIdPartida());
			int x = 0;
			for (String s: i.getUsuaris()){
				rows[1 + x] = s;
				x++;
			}
			SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy hh:mm");
			rows[1 + x] = d.format(i.getData());
			t.Insereix(rows);
		}
	}


	private static String[] CrearHeaders(int n){
		String[] j = CrearHeadersJugadors(n);
		String[] ret = new String[2 + n];
		int i = 0;
		ret[i] = ID; i++;
		for (int k = 0; k < n; k ++){
			ret[k + i] = j[k];
		}
		ret[i + n] = Data; i++;
		
		return ret;
	}
	
	private static String[] CrearHeadersJugadors(int n){
		String[] ret = new String[n];
		for (int i = 0; i < n; i++){
			ret[i] = Jugador + ": " + String.valueOf(i + 1);
		}
		return ret;
	}
	

}
