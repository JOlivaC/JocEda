package Domini.CasosUs;

import Domini.Factories.FactoriaControladors;
import Domini.Fitxers.FitxerResultat;
import Domini.Model.Partida;
import Excepcions.PartidaNoJugada;

public class CasUsVisualitzarPartida {
	public FitxerResultat VisualitzarPartida(int IDPartida) throws Exception{
		
		Partida p = FactoriaControladors.getInstance().getCtrlPartida().get(IDPartida);
		if (p.EstaJugada())  return (FitxerResultat)p.getPartidaResultant();
		else throw new PartidaNoJugada();
	}
}
