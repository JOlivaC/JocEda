package Comunicacio;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import Domini.LectorResultat.InfoJugador;

public class InfoResultat implements Comparable{
	public int IDPartida;
	public Set<InfoJugador> Jugadors;
	
	public InfoResultat(){
		Jugadors = new HashSet<>();

	}

	public static InfoResultat Stub( int id){
		InfoResultat ret = new InfoResultat();
		ret.IDPartida = id;
		ret.Jugadors.add(new InfoJugador("Manel",4));
		ret.Jugadors.add(new InfoJugador("Roger",5));
		ret.Jugadors.add(new InfoJugador("Pere",8));
		ret.Jugadors.add(new InfoJugador("Eulalia",10));
		return ret;
	}
	
	public static SortedSet<InfoResultat> ConjStub(){
		SortedSet<InfoResultat> ret = new TreeSet<>();
		for (int i = 0; i < 4; i++){
			ret.add(InfoResultat.Stub(i+1));
		}

		return ret;
	}
	


	@Override
	public int compareTo(Object o) {
		return Integer.valueOf(((InfoResultat)o).IDPartida).compareTo(this.IDPartida);
	}
	

}
