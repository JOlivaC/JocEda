package Comunicacio;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class InfoCalendariPartida implements Comparable<Object> ,Serializable{
	
	private Set<String> Usuaris;
	private int idPartida;
	private Date data;
	private boolean Jugada;
	
	public InfoCalendariPartida(){}
	public InfoCalendariPartida(Set<String> usuaris, int idPartida, Date data,boolean Jugada) {
		Usuaris = usuaris;
		this.idPartida = idPartida;
		this.data = data;
		this.Jugada = Jugada;
	}
	public Set<String> getUsuaris() {
		return Usuaris;
	}
	public void setUsuaris(Set<String> usuaris) {
		Usuaris = usuaris;
	}
	public int getIdPartida() {
		return idPartida;
	}
	public void setIdPartida(int idPartida) {
		this.idPartida = idPartida;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	@Override
	public int compareTo(Object arg0) {
		return Integer.compare(this.idPartida,((InfoCalendariPartida) arg0).idPartida);
	}
	public boolean isJugada() {
		return Jugada;
	}
	public void setJugada(boolean jugada) {
		Jugada = jugada;
	}
	
	
}
