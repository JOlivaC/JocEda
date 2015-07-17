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
import Excepcions.InsuficientsJugadors;

/**
 *
 * @author JOAN
 */
public class AlarmaJugar {
	private int IDPartida;
	private Date data;
	private transient Timer t;
	public AlarmaJugar(Date data,int IDPartida){
		this.data = data;
		this.IDPartida = IDPartida;
	}
	public AlarmaJugar() {

	}
	public void Sonar() {
		
		TxJugarPartida TJP;

		try {
			TJP = new TxJugarPartida(FactoriaControladors.getInstance().getCtrlPartida().get(IDPartida));
			TJP.Executar();	
			t.cancel();
		} catch (InsuficientsJugadors i){
			Log.LogServidor.WriteLine("Insuficients Jugadors per la partida" + String.valueOf(IDPartida));
		} catch (Exception e) {
			Log.LogServidor.WriteException(e);
		}
		
		
	}
	
	public void Programar(){
		if (data != null){
			t = new Timer();
			t.schedule(new Sonar(), data);
		}
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
	public int getID() {
		return IDPartida;
	}
	public void setID(int iD) {
		IDPartida = iD;
	}


}
