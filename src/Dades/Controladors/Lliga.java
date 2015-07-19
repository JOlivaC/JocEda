package Dades.Controladors;

import java.util.Set;

import Domini.InterficieBD.CtrlLliga;

public class Lliga extends Controlador implements CtrlLliga {

	@Override
	public Set<Domini.Model.Lliga> getAll() throws Exception {
		return (Set<Domini.Model.Lliga>) (Set<?>)super.getAll(Domini.Model.Lliga.class);
	}

	@Override
	public void Insert(Domini.Model.Lliga l) throws Exception {
		super.Insert(l);
		
	}

	@Override
	public void Delete(Domini.Model.Lliga l) throws Exception {
		super.Delete(l);
		
	}

	@Override
	public void Update(Domini.Model.Lliga l) throws Exception {
		super.Update(l);
		
	}

	@Override
	public Domini.Model.Lliga Get(int ID) throws Exception {
		return (Domini.Model.Lliga) super.get(Domini.Model.Lliga.class,ID);
	}

}
