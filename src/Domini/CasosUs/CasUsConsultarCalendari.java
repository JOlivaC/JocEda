package Domini.CasosUs;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import Comunicacio.InfoCalendariPartida;
import Domini.Factories.FactoriaControladors;
import Domini.Model.Partida;
import Domini.Model.Usuari;

public class CasUsConsultarCalendari {
	public SortedSet<InfoCalendariPartida> ConsultarCalendari() throws Exception{
		SortedSet<InfoCalendariPartida> ret = new TreeSet<>();
	
		Set<Partida> partides = FactoriaControladors.getInstance().getCtrlPartida().getAll();
		for (Partida p: partides){
			InfoCalendariPartida info = new InfoCalendariPartida();
			info.setData(p.getData());			
			info.setIdPartida(p.getID());
			info.setJugada(p.EstaJugada());
			Set<String> Usuaris = new HashSet<>();
			for (Usuari u: p.getParticipants()) Usuaris.add(u.getUsername());
			info.setUsuaris(Usuaris);
			ret.add(info);
		}
		
		return ret;

	}
}
