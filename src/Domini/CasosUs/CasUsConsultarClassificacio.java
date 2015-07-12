package Domini.CasosUs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import Comunicacio.InfoJugadorNPartides;
import Comunicacio.InfoJugadorPosicio;
import Comunicacio.InfoJugadorRanking;
import Domini.Factories.FactoriaControladors;
import Domini.Model.Jugador;
import Domini.Model.ResultatJugador;
import Domini.Model.Usuari;

public class CasUsConsultarClassificacio {
	public SortedSet<InfoJugadorRanking> ConsultarClassificacio(){
		SortedSet<InfoJugadorRanking> ret = new TreeSet<>();
		
		Set<ResultatJugador> resultats = FactoriaControladors.getInstance().getCtrlResultats().getAll();
		Set<Usuari> usuaris = FactoriaControladors.getInstance().getCtrlUsuari().getAll();
		
		for (Usuari u: usuaris){
			Set<Jugador> jugadors = u.getSetJugadors();
			Set<ResultatJugador> partidesJugades = new HashSet<>();
			for (Jugador j: jugadors){
				Set<ResultatJugador> Descartats = new HashSet<>();
				for (ResultatJugador RJ: resultats){
					if (RJ.getJ().equals(j)){
						partidesJugades.add(RJ);
						Descartats.add(RJ);
					}
					
				}
				resultats.removeAll(Descartats);
				
			}
			
			/* partidesJugades = partides que ha jugat l'usuari u */
			InfoJugadorRanking IJ = new InfoJugadorRanking();
			InfoJugadorNPartides IN = new InfoJugadorNPartides();
			InfoJugadorPosicio IP = new InfoJugadorPosicio();
			
			IP.setNom(u.getUsername());
			
			Map<Integer,Integer> Pos = new HashMap<>();
			int punts = 0;
			for (ResultatJugador R:partidesJugades){
				if (!Pos.containsKey(R.getPosicio())) Pos.put(R.getPosicio(),1);
				else Pos.put(R.getPosicio(), Pos.get(R.getPosicio()) + 1);

				punts += Domini.Model.Normes.getPuntsPosicio(R.getPosicio(), 4);
				
			}
			
			IN.setPosicions(Pos);
			IP.setPunts(punts);
			
			IJ.setN(IN);
			IJ.setPos(IP);
			
			ret.add(IJ);
		}
		
		return ret;
	}
}
