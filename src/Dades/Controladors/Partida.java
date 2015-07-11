package Dades.Controladors;

import java.util.Set;

import Domini.InterficieBD.CtrlPartida;

public class Partida extends Controlador implements CtrlPartida {

	@Override
	public Set<Domini.Model.Partida> getAll() throws Exception {
		return (Set<Domini.Model.Partida>) (Set<?>) super.getAll(Domini.Model.Partida.class);
	}

	@Override
	public Domini.Model.Partida get(int id) throws Exception {
		return (Domini.Model.Partida) super.get(Domini.Model.Partida.class,id);
	}

	@Override
	public void Update(Domini.Model.Partida p) throws Exception {
		super.Update(p);
		
	}

	@Override
	public void Insert(Domini.Model.Partida p) throws Exception {
		super.Insert(p);
		
	}



}
