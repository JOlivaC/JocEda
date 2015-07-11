package Domini.CasosUs;

import Domini.Factories.FactoriaControladors;
import Domini.Model.Usuari;

public class CasUsRegistrarse {
	public void Registrarse(String user,String pass) throws Exception{
		FactoriaControladors.getInstance().getCtrlUsuari().Insert(new Usuari(user,pass));
	}
}
