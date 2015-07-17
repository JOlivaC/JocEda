package Domini.Transaccions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import Comunicacio.Fitxer;
import Comunicacio.InfoJugadorPartida;
import Domini.Directoris.DirectoriObjectes;
import Domini.Directoris.DirectoriPartida;
import Domini.Execucions.Compilador;
import Domini.Execucions.Executor;
import Domini.Factories.FactoriaControladors;
import Domini.LectorResultat.InfoResultat;
import Domini.LectorResultat.LectorResultat;
import Domini.Model.Dummy;
import Domini.Model.Huma;
import Domini.Model.Jugador;
import Domini.Model.ResultatJugador;
import Domini.Model.Usuari;
import Excepcions.InsuficientsJugadors;

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
		CompilarPartida();
		RealitzarPartida();
		LlegirResultat();	
		Finalitzar();
	}
	
	public Fitxer getResultat(){
		return fres;
	}
	public InfoResultat getInfoResultat(){
		return r;
	}
	
	private void SituarObjectesPartida() throws Exception{
		DirectoriObjectes objectes = new DirectoriObjectes();
		dir.CopyAll(objectes);
	}
	private void SituarFitxers() throws Exception{
		SituarObjectesPartida();
		for (Jugador j: inscritsMap.values()){
			dir.AfegirJugador(j.getJugador());
		}	
		
		
	}
	private void CompilarPartida() throws IOException, Exception{
		Compilador c = new Compilador();
		c.compilarJoc(dir.getDir());
	}
	private void RealitzarPartida() throws IOException, Exception{	
		List<String> jugadors = new ArrayList<String>();
		jugadors.addAll(inscritsMap.keySet());
		Executor e = new Executor();
		resultat = e.executarJoc(jugadors, dir.getDir());
		fres = new Fitxer(resultat);
	}
	
	private void LlegirResultat() throws FileNotFoundException, IOException, Exception{
		LectorResultat l = new LectorResultat();
		r = l.Llegir(resultat);
		
	}

	private void Finalitzar(){
		dir.DestruirDirectori();
	}
	
	
}
