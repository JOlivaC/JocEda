package Dades.Tipus;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import Dades.Claus.PKAlarma;
import Dades.Claus.PrimaryKey;

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
		setIDPartida(rs.getInt(1));
		setData(new Date(rs.getTimestamp(2).getTime()));
	}
	@Override
	public void Escriure(PreparedStatement ps) throws SQLException {
		ps.setInt(1,getIDPartida());
		ps.setTimestamp(2, new Timestamp(getData().getTime()));
		
	}
	@Override
	public PrimaryKey getPK() {
		return new PKAlarma(this.getIDPartida());
	}
	
	
	
	
}
