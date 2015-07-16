package Domini.Transaccions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import Domini.Factories.FactoriaControladors;
import Domini.Generadors.GeneradorCombinacions;
import Domini.InterficieBD.CtrlLliga;
import Domini.InterficieBD.CtrlPartida;
import Domini.Model.Lliga;
import Domini.Model.Partida;
import Domini.Model.Usuari;

public class TxGenerarPartides {
	private Map<Integer,Usuari> Correspondencia;
	private int IDLliga;
	
	public TxGenerarPartides(int IDLliga){this.IDLliga = IDLliga;}
	
	public void executar() throws Exception{
		Set<Usuari> tots = FactoriaControladors.getInstance().getCtrlUsuari().getAll();
		Assigna(tots);
		Set<Integer> IDS = Correspondencia.keySet();
		GeneradorCombinacions g = new GeneradorCombinacions(IDS,4);
		Lliga l = new Lliga();
		int i = 0;
		for (Set<Integer> Partida : g.Generar()){
			Partida p = new Partida();
			p.setEstat(0);
			p.setParticipants(getUsuaris(Partida,tots));
			l.getPartides().add(i,p); i++;		
		}
		
		CtrlLliga ctrl = FactoriaControladors.getInstance().getCtrlLliga();
		l.setID(IDLliga);
		ctrl.Insert(l);
		
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
