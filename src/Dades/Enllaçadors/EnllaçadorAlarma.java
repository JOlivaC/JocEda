package Dades.Enllašadors;

import Actors.Alarmes.AlarmaJugar;
import Dades.Acces.AccesAlarma;
import Dades.Tipus.Alarma;
import Domini.Model.Partida;

public class EnllašadorAlarma {

	public AlarmaJugar get(int IDPartida,Partida enllašP) throws Exception{
		AccesAlarma a = new AccesAlarma();
		Alarma al = a.get(IDPartida);
		
		AlarmaJugar ret = new AlarmaJugar();
		
		ret.setData(al.getData());
		
		if (enllašP == null){
			EnllašadorPartida e = new EnllašadorPartida();
			ret.setPartida(e.get(IDPartida, ret));
		}
		else {
			ret.setPartida(enllašP);
		}
		
		return ret;
	}
}
