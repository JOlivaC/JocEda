package Domini.InterficieBD;

import java.util.Set;

import Dades.Excepcions.NoExisteixPartida;
import Domini.Model.Partida;

public interface CtrlPartida {
	public Set<Partida> getAll();
	public Partida get(int id) throws NoExisteixPartida;
}
