package Domini.CasosUs;

import java.io.File;
import java.io.IOException;

import Dades.Excepcions.NoExisteixPartida;
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
