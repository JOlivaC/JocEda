package Domini.CasosUs;

import Comunicacio.Fitxer;
import Domini.Factories.FactoriaControladors;
import Domini.Model.Partida;
import Excepcions.PartidaNoJugada;

public class CasUsVisualitzarPartida {
	public Fitxer VisualitzarPartida(int IDPartida) throws Exception{
		
		Partida p = FactoriaControladors.getInstance().getCtrlPartida().get(IDPartida);
		if (p.EstaJugada())  return p.getPartidaResultant();
		else throw new PartidaNoJugada();
	}
}
