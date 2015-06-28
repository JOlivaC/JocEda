package Domini.CasosUs;

import java.util.HashSet;
import java.util.SortedSet;
import java.util.TreeSet;

import Comunicacio.InfoJugadorPartida;
import Comunicacio.InfoPartida;

public class CasUsConsultarResultats {
	public SortedSet<InfoPartida> ConsultarResultats(){
		InfoPartida p = new InfoPartida();
		p.IDPartida = 4;
		p.Jugadors = new HashSet<>();
		
		for (int i = 0; i < 4; i++)
		p.Jugadors.add(new InfoJugadorPartida(String.valueOf(i),i));
		
		SortedSet<InfoPartida> ret = new TreeSet<>();
		ret.add(p);
		return ret;
	}
}
