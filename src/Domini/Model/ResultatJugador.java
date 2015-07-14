package Domini.Model;

import Comunicacio.InfoJugadorPartida;

public class ResultatJugador {
	private int ID;
	private int Posicio;
	private int Puntuacio;
	private Huma j;
	private Partida p;
	public int getPosicio() {
		return Posicio;
	}
	public void setPosicio(int posicio) {
		Posicio = posicio;
	}
	public int getPuntuacio() {
		return Puntuacio;
	}
	public void setPuntuacio(int puntuacio) {
		Puntuacio = puntuacio;
	}
	public Huma getJ() {
		return j;
	}
	public void setJ(Huma j) {
		this.j = j;
	}
	public Partida getP() {
		return p;
	}
	public void setP(Partida p) {
		this.p = p;
	}
	
	public InfoJugadorPartida getInfo(){
		return new InfoJugadorPartida(j.getName(),this.Puntuacio);
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	
	
}
