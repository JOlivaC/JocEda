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
import Domini.InterficieBD.CtrlPartida;
import Domini.LectorResultat.InfoResultat;
import Domini.LectorResultat.LectorResultat;
import Domini.Model.Dummy;
import Domini.Model.Huma;
import Domini.Model.Jugador;
import Domini.Model.Partida;
import Domini.Model.ResultatJugador;
import Domini.Model.Usuari;
import Excepcions.InsuficientsJugadors;

public class TxJugarPartida {
	
	
	private Partida p;
	private DirectoriPartida dir;
	private Map<String,Jugador> inscritsMap;
	private File resultat;

	public TxJugarPartida(Partida p){
		this.p = p; 

		inscritsMap = new HashMap<String,Jugador>();	
	}
	
	public void Executar() throws Exception {
		FerPartida();
		
		CtrlPartida ctrlp = FactoriaControladors.getInstance().getCtrlPartida();
		ctrlp.Update(p);
		
		
	}
	
	private void FerPartida() throws Exception{
		SituarFitxers();
		CompilarPartida();
		RealitzarPartida();
		LlegirResultat();
		FinalitzarPartida();
	}
	private void SituarObjectesPartida() throws Exception{
		dir = new DirectoriPartida(p.getID());
		DirectoriObjectes objectes = new DirectoriObjectes();
		dir.CopyAll(objectes);
	}
	private void SituarFitxers() throws Exception{
		SituarObjectesPartida();
		Set<Usuari> participants = p.getParticipants();
		Set<Huma> humas = new HashSet<>();
		Set<Usuari> invalids = new HashSet<>();

		for (Usuari u: participants){
			try {
				Huma j = u.GetJugadorActual();
				humas.add(j);
				inscritsMap.put(j.getName(),j);
			} catch (Exception e) {
				invalids.add(u);
			}
		}
		
		int i = 0;
		
		for (Huma j: humas){
			dir.AfegirJugador(j.getJugador());
			i++;
		}	
		
		if (i == 0) throw new InsuficientsJugadors();
		if (i < 4){
			Set<Dummy> dummys = FactoriaControladors.getInstance().getCtrlDummy().getAll();
			if (dummys.size() < 4 - i) throw new InsuficientsJugadors();
			Iterator<Dummy> it = dummys.iterator();
			while (i < 4){
				Dummy d = it.next();
				inscritsMap.put(d.getName(),d);
				dir.AfegirJugador(d.getJugador());
				i++;
			}
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
	}
	
	private void LlegirResultat() throws FileNotFoundException, IOException, Exception{
		LectorResultat l = new LectorResultat();
		InfoResultat r = l.Llegir(resultat);
		Vector<InfoJugadorPartida> res  = r.getResultat();
		for (int i = 0; i < res.size(); i ++){
			InfoJugadorPartida infoj = res.get(i);
			AfegirPuntuacio(i+1,infoj.getNom(),infoj.getPuntuacio());
		}
		Fitxer re = new Fitxer(resultat);
		re.setNom("Partida" + p.getID() + ".br");
		p.setPartidaResultant(re);
	}
	
	private void AfegirPuntuacio(int posicio,String nomJugador,int Puntuacio){
		Jugador j = inscritsMap.get(nomJugador);
		ResultatJugador R = new ResultatJugador();
		R.setJ(j);
		R.setP(p);
		R.setPosicio(posicio);
		R.setPuntuacio(Puntuacio);
		j.getPartidesJugades().add(p);
		p.getResultat().add(R);
	}
	private void FinalitzarPartida(){
		dir.DestruirDirectori();
		p.Acabar();
	}
}
