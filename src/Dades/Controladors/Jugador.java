package Dades.Controladors;

import java.util.Set;

import Domini.InterficieBD.CtrlJugador;

public class Jugador extends Controlador implements CtrlJugador {

	@Override
	public Set<Domini.Model.Jugador> getAll() throws Exception {
		return (Set<Domini.Model.Jugador>) (Set<?>) super.getAll(Domini.Model.Jugador.class);
	}

	@Override
	public void Insert(Domini.Model.Jugador j) throws Exception {
		super.Insert(j);
		
	}

	@Override
	public void Delete(Domini.Model.Jugador j) throws Exception {
		super.Delete(j);
		
	}

	@Override
	public void Update(Domini.Model.Jugador j) throws Exception {
		super.Update(j);
		
	}

	@Override
	public boolean Exists(String name) throws Exception {
		return super.Exists(Domini.Model.Jugador.class, name);
	}

	@Override
	public Domini.Model.Jugador get(String name) throws Exception {
		return (Domini.Model.Jugador) super.get(Domini.Model.Jugador.class, name);
	}

}
