package Domini.Transaccions;

import java.util.Calendar;
import java.util.Date;

import Actors.Alarmes.AlarmaJugar;
import Domini.Factories.FactoriaControladors;
import Domini.InterficieBD.CtrlAlarma;

public class TxGenerarAlarmes {
	private int n;
	private Date Inici;
	private Date Fi;
	public TxGenerarAlarmes(int n){
		this.n = n;
	}
	public void Executar(){
		CtrlAlarma ctrl = FactoriaControladors.getInstance().getCtrlAlarma();
		for (int i = 0; i < n; i++){
			ctrl.Insert(new AlarmaJugar(Calendar.getInstance().getTime(),i+1));
		}
	}
	
	public static void main(String argv[]){
		
		TxGenerarAlarmes t = new TxGenerarAlarmes(10);
		t.Executar();
	}
}
