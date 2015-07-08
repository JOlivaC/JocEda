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
	private int id;
	private Partida partida;
	private Date data;
	private transient Timer t;
	public AlarmaJugar(Date data,Partida p){
		this.data = data;
		this.partida = p;
		this.id = p.getID();
	}
	public AlarmaJugar() {
		// TODO Auto-generated constructor stub
	}
	public void Sonar() {
		//TODO
		//TxJugarPartida TJP = new TxJugarPartida(IDPartida);

		try {
			//TJP.Executar();
			CtrlAlarma ctrl = FactoriaControladors.getInstance().getCtrlAlarma();
			ctrl.Delete(this);
			t.cancel();
			
		} catch (Exception e) {
			System.out.print(e);
		}
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

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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


}
