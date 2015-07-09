package Domini.InterficieBD;

import java.util.Set;

import Domini.Model.Partida;

public interface CtrlPartida {
	public Set<Partida> getAll() throws Exception;
	public Partida get(int id) throws Exception;
	public void Update(Partida p) throws Exception;
	public void Insert(Partida p) throws Exception;
}
