package Domini.InterficieBD;

import java.util.Set;

import Domini.Model.Usuari;

public interface CtrlUsuari {
	public Usuari get(String User) throws Exception;
	public Set<Usuari> getAll();
	public void Insert(Usuari u) throws Exception;
	public void Delete(Usuari u) throws Exception;
	public void Update(Usuari u) throws Exception;
}
