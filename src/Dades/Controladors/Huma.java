package Dades.Controladors;

import java.util.Set;

import Domini.InterficieBD.CtrlHuma;

public class Huma extends Controlador implements CtrlHuma {

	@Override
	public Set<Domini.Model.Huma> getAll() throws Exception {
		return (Set<Domini.Model.Huma>) (Set<?>) super.getAll(Domini.Model.Huma.class);
	}

	@Override
	public void Insert(Domini.Model.Huma j) throws Exception {
		super.Insert(j);
		
	}
	
	


	@Override
	public void Delete(Domini.Model.Huma j) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Update(Domini.Model.Huma j) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean Exists(String name) throws Exception {
		return super.Exists(Domini.Model.Huma.class,name);
	}

	@Override
	public Domini.Model.Huma get(String name) throws Exception {
		return (Domini.Model.Huma) super.get(Domini.Model.Huma.class, name);
	}

}
