package Domini.Transaccions;

import java.util.Calendar;
import java.util.Date;

import Actors.Alarmes.AlarmaJugar;
import Dades.Controladors.TaulaAlarma;
import Domini.Factories.FactoriaControladors;
import Domini.InterficieBD.CtrlAlarma;

public class TxGenerarAlarmes {
	private int n;
	private Date Inici;
	private Date Fi;
	public TxGenerarAlarmes(int n){
		this.n = n;
	}
	public void Executar() throws Exception{
		new Dades.Controladors.Esquema().CrearEsquema();
		CtrlAlarma ctrl = FactoriaControladors.getInstance().getCtrlAlarma();
		ctrl.DeleteAll();
		for (int i = 0; i < n; i++){
			Date d = Calendar.getInstance().getTime();
			d.setSeconds(d.getSeconds() + 10);
			//ctrl.Insert(new AlarmaJugar(d,i+1));
		}
	}
	
	public static void main(String argv[]) throws Exception{
		
		TxGenerarAlarmes t = new TxGenerarAlarmes(10);
		t.Executar();
		TxEngegarAlarmes tx = new TxEngegarAlarmes();
		tx.Executar();
	}
}
