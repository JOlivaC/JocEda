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
import Domini.Transaccions.TxJugarPartida;
import Excepcions.ErrorPartida;

/**
 *
 * @author JOAN
 */
public class AlarmaJugar {
	private Date data;
	private int IDPartida;
	private Timer t;
	public AlarmaJugar(Date data,int IDPartida){
		this.data = data;
		this.IDPartida = IDPartida;
	}
	public void Sonar() {
		TxJugarPartida TJP = new TxJugarPartida(IDPartida);

		try {
			TJP.Executar();
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

	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public int getIDPartida() {
		return IDPartida;
	}
	public void setIDPartida(int iDPartida) {
		IDPartida = iDPartida;
	}
}
