package Dades.Tipus;

public abstract class PartidaJugador {
	private int IDPartida;
	private String nomJugador;
	
	public PartidaJugador(int iDPartida, String nomJugador) {
		IDPartida = iDPartida;
		this.nomJugador = nomJugador;
	}
	public PartidaJugador(){}
	public int getIDPartida() {
		return IDPartida;
	}
	public void setIDPartida(int iDPartida) {
		IDPartida = iDPartida;
	}
	public String getNomJugador() {
		return nomJugador;
	}
	public void setNomJugador(String nomJugador) {
		this.nomJugador = nomJugador;
	}
	
	
}
