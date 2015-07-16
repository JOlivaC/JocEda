package Domini.Transaccions;


import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import Actors.Alarmes.AlarmaJugar;
import Domini.Factories.FactoriaControladors;
import Domini.InterficieBD.CtrlAlarma;
import Domini.InterficieBD.CtrlLliga;
import Domini.InterficieBD.CtrlPartida;
import Domini.Model.Lliga;
import Domini.Model.Partida;

public class TxGenerarAlarmes {
	private int n;
	private Date Inici;
	private Date Fi;
	private LocalTime HoraInici;
	private LocalTime HoraFi;
	private int IDLliga;
	public TxGenerarAlarmes(Date I,Date F,LocalTime HI,LocalTime HF,int IDLliga){
		Inici = I;
		Fi = F;
		HoraInici = HI;
		HoraFi = HF;
		this.IDLliga = IDLliga;
	}
	public void Executar() throws Exception{
		Calendar cal = Calendar.getInstance();
		cal.setTime(Inici);
		
		CtrlLliga ctrlp = FactoriaControladors.getInstance().getCtrlLliga();
		List<Partida> s = ctrlp.Get(IDLliga).getPartides();
		n = s.size();
		Iterator<Partida> it = s.iterator();
		
		for (int j = 0; j < GetDiesFranja(); j++){
			cal.set(Calendar.HOUR_OF_DAY, HoraInici.getHour());
			cal.set(Calendar.MINUTE, HoraInici.getMinute());
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
		int i = Math.floorDiv(n,GetDiesFranja());
		return i;
	}


}
