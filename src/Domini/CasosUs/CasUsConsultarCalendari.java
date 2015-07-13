package Domini.CasosUs;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import Actors.Alarmes.AlarmaJugar;
import Comunicacio.InfoCalendariPartida;
import Domini.Factories.FactoriaControladors;
import Domini.Model.Partida;
import Domini.Model.Usuari;

public class CasUsConsultarCalendari {
	public SortedSet<InfoCalendariPartida> ConsultarCalendari() throws Exception{
		SortedSet<InfoCalendariPartida> ret = new TreeSet<>();
	
		Set<AlarmaJugar> alarmes = FactoriaControladors.getInstance().getCtrlAlarma().getAll();
		Set<Partida> Jugades = new HashSet<>();
		for (AlarmaJugar a: alarmes){
			InfoCalendariPartida info = new InfoCalendariPartida();
			info.setData(a.getData());			
			info.setIdPartida(a.getPartida().getID());
			info.setJugada(a.getPartida().EstaJugada());
			Set<String> Usuaris = new HashSet<>();
			for (Usuari u: a.getPartida().getParticipants()) Usuaris.add(u.getUsername());
			info.setUsuaris(Usuaris);
			ret.add(info);
		}
		
		return ret;
	}
}
