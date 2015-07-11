package Domini.InterficieBD;

import java.util.Set;

import Domini.Model.Jugador;

public interface CtrlJugador {
	public Set<Jugador> getAll() throws Exception;
	public void Insert(Jugador j) throws Exception;
	public void Delete(Jugador j) throws Exception;
	public void Update(Jugador j) throws Exception;
	public boolean Exists(String name) throws Exception;
}
