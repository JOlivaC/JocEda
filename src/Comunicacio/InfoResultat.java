package Comunicacio;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class InfoResultat implements Comparable{
	public int IDPartida;
	public Set<InfoJugadorPartida> Jugadors;
	
	public InfoResultat(){
		Jugadors = new HashSet<>();

	}

	public static InfoResultat Stub( int id){
		InfoResultat ret = new InfoResultat();
		ret.IDPartida = id;
		ret.Jugadors.add(new InfoJugadorPartida("Manel",4));
		ret.Jugadors.add(new InfoJugadorPartida("Roger",5));
		ret.Jugadors.add(new InfoJugadorPartida("Pere",8));
		ret.Jugadors.add(new InfoJugadorPartida("Eulalia",10));
		return ret;
	}
	
	public static SortedSet<InfoResultat> ConjStub(){
		SortedSet<InfoResultat> ret = new TreeSet<>();
		for (int i = 0; i < 50; i++){
			ret.add(InfoResultat.Stub(i+1));
		}

		return ret;
	}
	


	@Override
	public int compareTo(Object o) {
		return Integer.valueOf(((InfoResultat)o).IDPartida).compareTo(this.IDPartida);
	}
	

}
