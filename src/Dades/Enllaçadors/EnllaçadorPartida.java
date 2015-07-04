package Dades.Enlla�adors;

import Actors.Alarmes.AlarmaJugar;
import Dades.Acces.AccesPartida;
import Dades.Factories.FactoriaAccessos;
import Dades.Factories.FactoriaEnlla�adors;
import Domini.Model.Partida;

public  class Enlla�adorPartida {

	private Enlla�adorFitxer EnFitxer = FactoriaEnlla�adors.getInstance().getEnlla�adorFitxer();
	private AccesPartida APartida = FactoriaAccessos.getInstance().getAccesPartida();
	
	public Partida Get(int IDPartida) throws Exception{
		return null;
	}
	
	public void InsertIf(Partida p) throws Exception{
		
	}
	
	public void Insert(Partida p) throws Exception{
		if (p.getPartidaResultant() != null){
			EnFitxer.InsertIf(p.getPartidaResultant());
			APartida.Insert(new Dades.Tipus.Partida(p.getID(), p.getPartidaResultant().getNom(), p.getEstat()));
			// Per tots els participants cridar al enlla�ador (p,p.getParticpants
			// Per tot resultat cridar a l'enlla�ador
			// 
		}
		
	}
	
	public void Update(Partida p) throws Exception{
		
	}
	
	public void Delete(Partida p) throws Exception {
		
	}
	

	
	
}
