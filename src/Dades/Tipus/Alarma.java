package Dades.Tipus;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Alarma extends TipusBD{
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
	@Override
	public void Llegir(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void Escriure(PreparedStatement ps) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
