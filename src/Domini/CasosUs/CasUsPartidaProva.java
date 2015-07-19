package Domini.CasosUs;

import java.util.HashSet;
import java.util.Set;

import Comunicacio.Fitxer;
import Domini.Factories.FactoriaControladors;
import Domini.Model.Jugador;

import Domini.Transaccions.TxFerPartida;

public class CasUsPartidaProva {
	public Fitxer PartidaProva(Set<String> Jugadors) throws Exception{
		if (Jugadors.size() != 4) throw new Exception("El nombre de jugadors ha de ser 4");
		
		Set<Jugador> participants = new HashSet<>();
		for (String s: Jugadors){participants.add(FactoriaControladors.getInstance().getCtrlJugador().get(s));}
		
		
		TxFerPartida t = new TxFerPartida(participants,"prova");
		t.Executar();
		return t.getResultat();
		
		
	}
}
