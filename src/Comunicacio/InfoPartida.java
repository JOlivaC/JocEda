package Comunicacio;

import java.util.HashSet;
import java.util.Set;

public class InfoPartida extends Tipus implements Comparable<Object>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int IDPartida;
	public Set<InfoJugadorPartida> Jugadors;
	
	public InfoPartida(){
		Jugadors = new HashSet<>();

	}
	


	@Override
	public int compareTo(Object o) {
		return Integer.valueOf(((InfoPartida)o).IDPartida).compareTo(this.IDPartida);
	}



	public int getIDPartida() {
		return IDPartida;
	}



	public void setIDPartida(int iDPartida) {
		IDPartida = iDPartida;
	}



	public Set<InfoJugadorPartida> getJugadors() {
		return Jugadors;
	}



	public void setJugadors(Set<InfoJugadorPartida> jugadors) {
		Jugadors = jugadors;
	}
	

}
