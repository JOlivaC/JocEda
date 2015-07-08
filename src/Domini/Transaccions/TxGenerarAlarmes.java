package Domini.Transaccions;


import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

import Actors.Alarmes.AlarmaJugar;
import Domini.Factories.FactoriaControladors;
import Domini.InterficieBD.CtrlAlarma;
import Domini.InterficieBD.CtrlPartida;
import Domini.Model.Partida;

public class TxGenerarAlarmes {
	private int n;
	private Date Inici;
	private Date Fi;
	private LocalTime HoraInici;
	private LocalTime HoraFi;
	
	public TxGenerarAlarmes(Date I,Date F,LocalTime HI,LocalTime HF){
		Inici = I;
		Fi = F;
		HoraInici = HI;
		HoraFi = HF;
	}
	public void Executar() throws Exception{
		CtrlAlarma ctrl = FactoriaControladors.getInstance().getCtrlAlarma();
		ctrl.DeleteAll();
		
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(Inici);
		
		CtrlPartida ctrlp = FactoriaControladors.getInstance().getCtrlPartida(); 
		SortedSet<Partida> s = new TreeSet<>();
		s.addAll(ctrlp.getAll());
		
		n = s.size();
		Iterator<Partida> it = s.iterator();
		
		for (int j = 0; j < GetDiesFranja(); j++){
			cal.set(Calendar.HOUR_OF_DAY, HoraInici.getHour());
			for (int k = 0; k < GetCopsDia(); k++){
				Date d = cal.getTime();
				CrearAlarma(it.next(),d);
				cal.add(Calendar.SECOND, GetSegonsFranja());
			}
	        cal.add(Calendar.DATE,1); //minus number would decrement the days
		}
		
	}
	private void CrearAlarma(Partida p,Date data) throws Exception{
		CtrlAlarma ctrl = FactoriaControladors.getInstance().getCtrlAlarma();
		ctrl.Insert(new AlarmaJugar(data,p));
	}
	
	private int GetSegonsFranja(){
		int ret= GetSegonsDia() / GetCopsDia();
		return ret;
	}
	private int GetDiesFranja(){
		final long DAY_IN_MILLIS = 1000 * 60 * 60 * 24;

		int i = (int) ((Fi.getTime() - Inici.getTime())/ DAY_IN_MILLIS );
		return i + 1;
	}
	private int GetSegonsDia(){
		int i = HoraFi.toSecondOfDay() - HoraInici.toSecondOfDay();
		return i;
	}
	private int GetCopsDia(){
		int i = n / GetDiesFranja();
		return i;
	}
	
	public static void main(String argv[]) throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date i = sdf.parse("1/1/2000");
		Date f = sdf.parse("15/1/2000");
		LocalTime in = LocalTime.of(8, 0);
		LocalTime fn = LocalTime.of(16, 0);
		TxGenerarAlarmes t = new TxGenerarAlarmes(i,f,in,fn);
		t.Executar();
	}

}
