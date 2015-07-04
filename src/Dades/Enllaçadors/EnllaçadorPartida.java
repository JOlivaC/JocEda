package Dades.Enllaçadors;

import Actors.Alarmes.AlarmaJugar;
import Dades.Acces.AccesPartida;
import Dades.Factories.FactoriaAccessos;
import Dades.Factories.FactoriaEnllaçadors;
import Domini.Model.Partida;

public  class EnllaçadorPartida {

	private EnllaçadorFitxer EnFitxer = FactoriaEnllaçadors.getInstance().getEnllaçadorFitxer();
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
			// Per tots els participants cridar al enllaçador (p,p.getParticpants
			// Per tot resultat cridar a l'enllaçador
			// 
		}
		
	}
	
	public void Update(Partida p) throws Exception{
		
	}
	
	public void Delete(Partida p) throws Exception {
		
	}
	

	
	
}
