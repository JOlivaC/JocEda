package Dades.Enllaçadors;

import Actors.Alarmes.AlarmaJugar;
import Dades.Acces.AccesAlarma;
import Dades.Tipus.Alarma;
import Domini.Model.Partida;

public class EnllaçadorAlarma {

	public AlarmaJugar get(int IDPartida,Partida enllaçP) throws Exception{
		AccesAlarma a = new AccesAlarma();
		Alarma al = a.get(IDPartida);
		
		AlarmaJugar ret = new AlarmaJugar();
		
		ret.setData(al.getData());
		
		if (enllaçP == null){
			EnllaçadorPartida e = new EnllaçadorPartida();
			ret.setPartida(e.get(IDPartida, ret));
		}
		else {
			ret.setPartida(enllaçP);
		}
		
		return ret;
	}
}
