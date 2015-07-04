package Dades.Enllaçadors;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import Actors.Alarmes.AlarmaJugar;
import Dades.Acces.AccesAlarma;
import Dades.Claus.PKAlarma;
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
	

	public AlarmaJugar Get(int IDPartida) throws Exception{
		
		AlarmaJugar ret;
		if ((ret = Prefetch(IDPartida)) == null){
		
			Alarma al = (Alarma) acces.get(new PKPartida(IDPartida));
			ret = new AlarmaJugar();
			Cache.put(IDPartida, ret);
			
			ret.setData(al.getData());
			ret.setPartida(EnPartida.Get(IDPartida));
		}
		
		return ret;
	}
	
	public void Insert(AlarmaJugar a) throws Exception{
		EnPartida.InsertIf(a.getPartida());
		acces.Insert(new Dades.Tipus.Alarma(a.getPartida().getID(),a.getData()));
	}
	
	public void Update(AlarmaJugar a) throws Exception{
		EnPartida.InsertIf(a.getPartida());
		EnPartida.Update(a.getPartida());
		acces.Update(new Dades.Tipus.Alarma(a.getPartida().getID(),a.getData()));
	}
	
	public void Delete(AlarmaJugar a) throws Exception {
		acces.Delete(new PKAlarma(a.getPartida().getID()));
	}
	
	public Set<AlarmaJugar> getAll() throws Exception{
		Set<AlarmaJugar> ret = new HashSet<>();
		Set<Alarma> als = (Set<Alarma>) (Set<?>) acces.getAll();
		for (Alarma a: als){
			AlarmaJugar al;
			if (!Cache.containsKey(a.getIDPartida())) {
				al = new AlarmaJugar();
				Cache.put(a.getIDPartida(), al);
				EnPartida.Get(a.getIDPartida());
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
