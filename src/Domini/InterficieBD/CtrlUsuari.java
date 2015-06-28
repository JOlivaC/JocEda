package Domini.InterficieBD;

import Dades.Excepcions.NoExisteixUsuari;
import Domini.Model.Usuari;

public interface CtrlUsuari {
	public Usuari get(String User) throws NoExisteixUsuari;
	
}
