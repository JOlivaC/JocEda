package Dades.Controladors;

import java.util.Set;

import Actors.Alarmes.AlarmaJugar;
import Domini.InterficieBD.CtrlAlarma;

public class Alarma extends Controlador implements CtrlAlarma {

	@SuppressWarnings("unchecked")
	@Override
	public Set<AlarmaJugar> getAll() throws Exception {
		return (Set<AlarmaJugar>)(Set<?>)super.getAll(AlarmaJugar.class);
	}

	@Override
	public void Insert(AlarmaJugar a) throws Exception {
		super.Insert(a);
	}

	@Override
	public void DeleteAll() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Delete(AlarmaJugar a) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Delete(int IDPartida) throws Exception {
		// TODO Auto-generated method stub
		
	}



	
}
