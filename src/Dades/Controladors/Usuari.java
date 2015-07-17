package Dades.Controladors;

import java.util.Set;

import Domini.InterficieBD.CtrlUsuari;

public class Usuari  extends Controlador implements CtrlUsuari{

	@Override
	public Domini.Model.Usuari get(String User) throws Exception {
		return (Domini.Model.Usuari) super.get(Domini.Model.Usuari.class, User);
	}

	@Override
	public Set<Domini.Model.Usuari> getAll() {
		return (Set<Domini.Model.Usuari>)(Set<?>)super.getAll(Domini.Model.Usuari.class);
	}

	@Override
	public void Insert(Domini.Model.Usuari u) throws Exception {
		super.Insert(u);
		
	}

	@Override
	public void Delete(Domini.Model.Usuari u) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Update(Domini.Model.Usuari u) throws Exception {
		super.Update(u);
		
	}

}
