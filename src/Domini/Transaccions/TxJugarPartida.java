package Domini.Transaccions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import Comunicacio.Fitxer;
import Comunicacio.InfoJugadorPartida;
import Domini.Directoris.DirectoriPartida;
import Domini.Execucions.Compilador;
import Domini.Execucions.Executor;
import Domini.Factories.FactoriaControladors;
import Domini.InterficieBD.CtrlAlarma;
import Domini.InterficieBD.CtrlPartida;
import Domini.LectorResultat.InfoResultat;
import Domini.LectorResultat.LectorResultat;
import Domini.Model.Jugador;
import Domini.Model.Partida;
import Domini.Model.ResultatJugador;
import Domini.Model.Usuari;

public class TxJugarPartida {
	
	
	private Partida p;
	private DirectoriPartida dir;
	private Map<String,Jugador> inscritsMap;
	private File resultat;
	public static void main(String[] argv) throws Exception{
		for (Partida par: FactoriaControladors.getInstance().getCtrlPartida().getAll())
			new TxJugarPartida(par).Executar();
	}
	public TxJugarPartida(Partida p){
		this.p = p; 
		dir = new DirectoriPartida();
		inscritsMap = new HashMap<String,Jugador>();	
	}
	
	public void Executar() throws Exception {
		FerPartida();
		
		CtrlPartida ctrlp = FactoriaControladors.getInstance().getCtrlPartida();
		ctrlp.Update(p);
		
		CtrlAlarma ctrl = FactoriaControladors.getInstance().getCtrlAlarma();
		ctrl.Delete(p.getID());
	}
	
	private void FerPartida() throws Exception{
		SituarFitxers();
		CompilarPartida();
		RealitzarPartida();
		LlegirResultat();
		FinalitzarPartida();
	}
	private void SituarFitxers() throws Exception{
		Set<Usuari> participants = p.getParticipants();
		Set<Jugador> jugadors = new HashSet<>();
		Set<Usuari> invalids = new HashSet<>();
		Set<Jugador> all = FactoriaControladors.getInstance().getCtrlJugador().getAll();

		for (Usuari u: participants){
			try {
				Jugador j = u.GetJugadorActual();
				jugadors.add(j);
				inscritsMap.put(j.getName(),j);
			} catch (Exception e) {
				invalids.add(u);
			}
		}
		
		
		for (Jugador j: jugadors){
			dir.AfegirJugador(j.getJugador());
		}		
		
		// cal poder realitzar partides amb menys de 4 jugadors, responsabilitat del compilador / executor
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
		dir.Natejar();
		p.Acabar();
	}
}
