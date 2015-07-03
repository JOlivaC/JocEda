package Dades.Enllaçadors;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import Actors.Alarmes.AlarmaJugar;
import Dades.Acces.AccesAlarma;
import Dades.Claus.PKPartida;
import Dades.Claus.PrimaryKey;
import Dades.Factories.FactoriaAccessos;
import Dades.Factories.FactoriaEnllaçadors;
import Dades.Tipus.Alarma;
import Dades.Tipus.TipusBD;

public class EnllaçadorAlarma {
	private  Map<Integer,AlarmaJugar> Cache = new HashMap<Integer,AlarmaJugar>();
	private AccesAlarma acces = FactoriaAccessos.getInstance().getAccesAlarma();
	private EnllaçadorPartida EnPartida = FactoriaEnllaçadors.getInstance().getEnllaçadorPartida();
	

	public AlarmaJugar get(int IDPartida) throws Exception{
		
		AlarmaJugar ret;
		if ((ret = Prefetch(IDPartida)) == null){
		
			Alarma al = (Alarma) acces.get(new PKPartida(IDPartida));
			ret = new AlarmaJugar();
			Cache.put(IDPartida, ret);
			
			ret.setData(al.getData());
			ret.setPartida(EnPartida.get(IDPartida));
		}
		
		return ret;
	}
	
	public void Insert(AlarmaJugar a) throws Exception{
		
	}
	
	public Set<AlarmaJugar> getAll() throws Exception{
		Set<AlarmaJugar> ret = new HashSet<>();
		Set<Alarma> als = (Set<Alarma>) (Set<?>) acces.getAll();
		for (Alarma a: als){
			AlarmaJugar al;
			if (!Cache.containsKey(a.getIDPartida())) {
				al = new AlarmaJugar();
				Cache.put(a.getIDPartida(), al);
				EnPartida.get(a.getIDPartida());
			} else {
				al = Cache.get(a.getIDPartida());

			}
				
			ret.add(al);
		}
		
		
		
		
		return ret;
	}
	
	private  AlarmaJugar Prefetch(int IDPartida){
		if (Cache.containsKey(IDPartida)) return Cache.get(IDPartida);
		else return null;
	}
}
