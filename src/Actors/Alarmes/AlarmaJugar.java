/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actors.Alarmes;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import Domini.Transaccions.TxJugarPartida;
import Excepcions.ErrorPartida;

/**
 *
 * @author JOAN
 */
public class AlarmaJugar {
	private Date data;
	private int IDPartida;
	public AlarmaJugar(Date data,int IDPartida){
		this.data = data;
		this.IDPartida = IDPartida;
	}
	public void Sonar() {
		TxJugarPartida TJP = new TxJugarPartida(IDPartida);

		try {
			TJP.Executar();
		} catch (ErrorPartida e) {
			System.out.print(e);
		}
	}
	
	public void Programar(){
		Timer t = new Timer();
		t.schedule(new Sonar(), data);
	}
	
	private class Sonar extends TimerTask{

		@Override
		public void run() {
			Sonar();			
		}
		
	}
}
