package Domini.CasosUs;

import Domini.Factories.FactoriaControladors;
import Domini.Model.Normes;
import Domini.Model.Usuari;

public class CasUsRegistrarse {
	public void Registrarse(String user,String pass) throws Exception{
		if (!Normes.IsUserValid(user)) throw new Exception("Nom invalid");
		FactoriaControladors.getInstance().getCtrlUsuari().Insert(new Usuari(user,pass));
	}
}
