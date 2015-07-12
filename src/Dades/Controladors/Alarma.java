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
		super.DeleteAll("Actors.Alarmes.AlarmaJugar");
		
	}

	@Override
	public void Delete(AlarmaJugar a) throws Exception {
		super.Delete(a);
		
	}

	@Override
	public void Delete(int IDPartida) throws Exception {
		super.Delete(Actors.Alarmes.AlarmaJugar.class, IDPartida);	
	}



	
}
