package Dades.Controladors;

import java.util.Set;

import Domini.InterficieBD.CtrlResultat;
import Domini.Model.ResultatJugador;

public class Resultat extends Controlador implements CtrlResultat {

	@Override
	public Set<ResultatJugador> getAll() {
		return (Set<Domini.Model.ResultatJugador>) (Set<?>) super.getAll(Domini.Model.ResultatJugador.class);
	}

}
