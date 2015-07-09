package Domini.InterficieBD;

import java.util.Set;

import Dades.Excepcions.NoExisteixPartida;
import Domini.Model.Partida;

public interface CtrlPartida {
	public Set<Partida> getAll() throws Exception;
	public Partida get(int id) throws Exception;
	public void update(Partida p) throws Exception;
	public void Insert(Partida p) throws Exception;
}
