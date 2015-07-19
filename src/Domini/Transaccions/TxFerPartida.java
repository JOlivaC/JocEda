package Domini.Transaccions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import Comunicacio.Fitxer;
import Domini.Directoris.DirectoriMapes;
import Domini.Directoris.DirectoriObjectes;
import Domini.Directoris.DirectoriPartida;
import Domini.Execucions.Compilador;
import Domini.Execucions.Executor;
import Domini.LectorResultat.InfoResultat;
import Domini.LectorResultat.LectorResultat;
import Domini.Model.Jugador;

public class TxFerPartida {
	private Map<String,Jugador> inscritsMap;
	
	private DirectoriPartida dir;
	
	private Set<Jugador> jugadors;
	private String NomDirectori;
	
	private File resultat;
	private InfoResultat r;
	private Fitxer fres;
	
	public TxFerPartida(Set<Jugador> jugadors,String NomDirectori) throws IOException{
		this.jugadors = jugadors;
		this.NomDirectori = NomDirectori;
	}
	private void IniciarEstructures() throws IOException{
		dir = new DirectoriPartida(NomDirectori);
		inscritsMap = new HashMap<String,Jugador>();
		for (Jugador j: jugadors) 
		inscritsMap.put(j.getName(), j);
	}
	
	public void Executar() throws Exception{
		IniciarEstructures();
		SituarFitxers();
		try{
			CompilarPartida();
			RealitzarPartida();
			LlegirResultat();	
		}
		catch (Exception e){
			throw e;
		}
		finally {
			Finalitzar();
		}
	}
	
	public Fitxer getResultat(){
		return fres;
	}
	public InfoResultat getInfoResultat(){
		return r;
	}
	
	private void SituarFitxers() throws Exception{
		for (Jugador j: inscritsMap.values()){
			dir.AfegirJugador(j.getJugador());
		}	
		
		
	}
	private void CompilarPartida() throws IOException, Exception{
		Compilador c = new Compilador();
		c.compilarJoc(dir.getDir(),new DirectoriObjectes().getDir());
	}
	private void RealitzarPartida() throws IOException, Exception{	
		List<String> jugadors = new ArrayList<String>();
		jugadors.addAll(inscritsMap.keySet());
		Executor e = new Executor();
		resultat = e.executarJoc(jugadors, dir.getDir(),new DirectoriMapes().getDir());
		
	}
	
	private void LlegirResultat() throws FileNotFoundException, IOException, Exception{
		LectorResultat l = new LectorResultat();
		r = l.Llegir(resultat);
		
		fres = new Fitxer(resultat);
	}

	private void Finalitzar(){
		dir.DestruirDirectori();
	}
	
	
}
