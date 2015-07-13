/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actors.Alarmes;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import Domini.Factories.FactoriaControladors;
import Domini.InterficieBD.CtrlAlarma;
import Domini.Model.Partida;
import Domini.Transaccions.TxJugarPartida;
import Excepcions.ErrorPartida;

/**
 *
 * @author JOAN
 */
public class AlarmaJugar {
	private int ID;
	private Partida partida;
	private Date data;
	private transient Timer t;
	public AlarmaJugar(Date data,Partida p){
		this.data = data;
		this.partida = p;
		this.ID = p.getID();
	}
	public AlarmaJugar() {

	}
	public void Sonar() {
		TxJugarPartida TJP = new TxJugarPartida(partida);

		try {
			TJP.Executar();	
		} catch (Exception e) {
			System.out.print(e);
		}
		
		t.cancel();
	}
	
	public void Programar(){
		t = new Timer();
		t.schedule(new Sonar(), data);
	}
	
	private class Sonar extends TimerTask{

		@Override
		public void run() {
			Sonar();
		}
		
	}


	public Partida getPartida() {
		return partida;
	}
	public void setPartida(Partida partida) {
		this.partida = partida;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}


}
