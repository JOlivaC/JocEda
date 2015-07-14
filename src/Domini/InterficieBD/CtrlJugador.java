package Domini.InterficieBD;

import java.util.Set;

import Domini.Model.Huma;

public interface CtrlJugador {
	public Set<Huma> getAll() throws Exception;
	public void Insert(Huma j) throws Exception;
	public void Delete(Huma j) throws Exception;
	public void Update(Huma j) throws Exception;
	public boolean Exists(String name) throws Exception;
}
