package Domini.CasosUs;

import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import Comunicacio.InfoPartida;
import Domini.Factories.FactoriaControladors;
import Domini.Model.Partida;

public class CasUsConsultarResultats {
	public SortedSet<InfoPartida> ConsultarResultats() throws Exception{
		List<Partida> partides = FactoriaControladors.getInstance().getCtrlLliga().Get(6).getPartides();
		SortedSet<InfoPartida> ret = new TreeSet<>();
		for (Partida p: partides){
			if (p.EstaJugada())
			ret.add(p.getInfo());
		}
		return ret;
	}
}
