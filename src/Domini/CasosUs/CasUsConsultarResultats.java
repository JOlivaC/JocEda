package Domini.CasosUs;

import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import Comunicacio.InfoPartida;
import Domini.Factories.FactoriaControladors;
import Domini.Model.Partida;

public class CasUsConsultarResultats {
	public SortedSet<InfoPartida> ConsultarResultats(){
		Set<Partida> partides = FactoriaControladors.getInstance().getCtrlPartida().getAll();
		SortedSet<InfoPartida> ret = new TreeSet<>();
		for (Partida p: partides){
			ret.add(p.getInfo());
		}
		return ret;
	}
}
