package Dades.Enlla�adors;

import Actors.Alarmes.AlarmaJugar;
import Dades.Acces.AccesAlarma;
import Dades.Tipus.Alarma;
import Domini.Model.Partida;

public class Enlla�adorAlarma {

	public AlarmaJugar get(int IDPartida,Partida enlla�P) throws Exception{
		AccesAlarma a = new AccesAlarma();
		Alarma al = a.get(IDPartida);
		
		AlarmaJugar ret = new AlarmaJugar();
		
		ret.setData(al.getData());
		
		if (enlla�P == null){
			Enlla�adorPartida e = new Enlla�adorPartida();
			ret.setPartida(e.get(IDPartida, ret));
		}
		else {
			ret.setPartida(enlla�P);
		}
		
		return ret;
	}
}
