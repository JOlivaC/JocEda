package Domini.InterficieBD;

import java.util.Set;

import Dades.Excepcions.NoExisteixUsuari;
import Domini.Model.Usuari;

public interface CtrlUsuari {
	public Usuari get(String User) throws NoExisteixUsuari;
	public Set<Usuari> getAll();
}
