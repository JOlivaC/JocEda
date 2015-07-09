package Domini.Transaccions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import Domini.Factories.FactoriaControladors;
import Domini.Generadors.GeneradorCombinacions;
import Domini.InterficieBD.CtrlPartida;
import Domini.Model.Partida;
import Domini.Model.Usuari;

public class TxGenerarPartides {
	private Map<Integer,Usuari> Correspondencia;
	public void executar() throws Exception{
		Set<Usuari> tots = FactoriaControladors.getInstance().getCtrlUsuari().getAll();
		Assigna(tots);
		Set<Integer> IDS = Correspondencia.keySet();
		GeneradorCombinacions g = new GeneradorCombinacions(IDS,4);
		int i = 0;
		
		for (Set<Integer> Partida : g.Generar()){
			Partida p = new Partida();
			p.setID(i++);
			p.setEstat(0);
			p.setParticipants(getUsuaris(Partida,tots));
			CtrlPartida ctrl = FactoriaControladors.getInstance().getCtrlPartida();
			ctrl.Insert(p);
		}
		
	}
	private void Assigna(Set<Usuari> Tots){
		Correspondencia = new HashMap<Integer,Usuari>();
		int i = 0;
		for (Usuari u : Tots){
			Correspondencia.put(i, u);
			i++;
		}
	}
	
	
	private Set<Usuari> getUsuaris(Set<Integer> IDS,Set<Usuari> Tots){
		Set<Usuari> ret = new HashSet<>();
		for (Integer i: IDS){
			ret.add(Correspondencia.get(i));
		}
		return ret;
	}
}
