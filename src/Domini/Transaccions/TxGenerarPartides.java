package Domini.Transaccions;

import java.util.Set;

import Domini.Factories.FactoriaControladors;
import Domini.Generadors.GeneradorCombinacions;
import Domini.InterficieBD.CtrlPartida;
import Domini.Model.Jugador;
import Domini.Model.Partida;

public class TxGenerarPartides {
	
	public void executar(){
		//TODO
		Set<Jugador> tots = null;
		// Agafar tots els jugadors
		// Agafar els id's dels jugadors
		GeneradorCombinacions g = new GeneradorCombinacions(null,4);
		int i = 0;
		for (Set<Integer> Partida : g.Generar()){
			Partida p = new Partida();
			p.setID(i);
			p.setEstat(0);
			p.setParticipants(getJugadors(Partida,tots));
			CtrlPartida ctrl = FactoriaControladors.getInstance().getCtrlPartida();
			//ctrl.Insert(p)
		}
		
		// generar alarmes
	}
	
	private Set<Jugador> getJugadors(Set<Integer> IDS,Set<Jugador> Tots){
		return null;
	}
}
