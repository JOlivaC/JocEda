package Dades.Controladors;

import java.util.Set;

import Domini.InterficieBD.CtrlDummy;

public class Dummy extends Controlador implements CtrlDummy {

	@Override
	public Set<Domini.Model.Dummy> getAll() throws Exception {
		return (Set<Domini.Model.Dummy>) (Set<?>)super.getAll(Domini.Model.Dummy.class);
	}

	@Override
	public void Insert(Domini.Model.Dummy d) throws Exception {
		super.Insert(d);
		
	}

	@Override
	public void Delete(Domini.Model.Dummy d) throws Exception {
		super.Delete(d);
		
	}

	@Override
	public void Update(Domini.Model.Dummy d) throws Exception {
		super.Update(d);
		
	}

	
	
	
}
