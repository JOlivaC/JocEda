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

	private Set<Jugador> jugadors;
	private Map<String,Jugador> inscritsMap;
	
	private InfoResultat r;
	private Fitxer fres;
	public TxJugarPartida(Partida p){
		this.p = p; 
			
	}
	
	public void Executar() throws Exception {
		AfegirParticipants();
		FerPartida();
		LlegirResultat();
		FinalitzarPartida();
		
		CtrlPartida ctrlp = FactoriaControladors.getInstance().getCtrlPartida();
		ctrlp.Update(p);	
		
	}
	
	private void AfegirParticipants() throws Exception{
		Set<Usuari> participants = p.getParticipants();
		Set<Usuari> invalids = new HashSet<>();
		jugadors = new HashSet<>();
		
		
		int i = 0;
		
		for (Usuari u: participants){
			try {
				Huma j = u.GetJugadorActual();
				jugadors.add(j);
				i++;
			} catch (Exception e) {
				invalids.add(u);
			}
		}
		
		
		
		
		if (i == 0) throw new InsuficientsJugadors();
		if (i < 4){
			Set<Dummy> dummys = FactoriaControladors.getInstance().getCtrlDummy().getAll();
			if (dummys.size() < 4 - i) throw new InsuficientsJugadors();
			Iterator<Dummy> it = dummys.iterator();
			while (i < 4){
				Dummy d = it.next();
				jugadors.add(d);
				i++;
			}
		}
		
		inscritsMap = new HashMap<String,Jugador>();
		for (Jugador j: jugadors) inscritsMap.put(j.getName(), j);
		
	}
	
	private void FerPartida() throws Exception{
		
		TxFerPartida t = new TxFerPartida(jugadors,"Partida" + p.getID());
		t.Executar();
		r = t.getInfoResultat();
		fres = t.getResultat();

	}

	
	private void LlegirResultat() throws FileNotFoundException, IOException, Exception{
		Vector<InfoJugadorPartida> res  = r.getResultat();
		for (int i = 0; i < res.size(); i ++){
			InfoJugadorPartida infoj = res.get(i);
			AfegirPuntuacio(i+1,infoj.getNom(),infoj.getPuntuacio());
		}
		fres.setNom("Partida" + p.getID() + ".br");
		p.setPartidaResultant(fres);
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
		p.Acabar();
	}
}
