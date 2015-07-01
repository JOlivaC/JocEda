package Dades.Tipus;

import java.util.Date;

public class Alarma {
	private int IDPartida;
	private Date data;
	public Alarma(){}
	public Alarma(int ID, Date date) {
		IDPartida = ID;
		data = date;
	}
	public int getIDPartida() {
		return IDPartida;
	}
	public void setIDPartida(int iDPartida) {
		IDPartida = iDPartida;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
	
	
	
}
