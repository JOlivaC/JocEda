package Domini.CasosUs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import Comunicacio.InfoUsuarisJugadors;
import Domini.Factories.FactoriaControladors;
import Domini.Model.Dummy;
import Domini.Model.Huma;
import Domini.Model.Jugador;
import Domini.Model.Usuari;

public class CasUsObrirProves {

	
	public InfoUsuarisJugadors ObrirProves(Usuari user) throws Exception{
		Set<Usuari> users = FactoriaControladors.getInstance().getCtrlUsuari().getAll();
		
		Map<String,Set<String>> info = new HashMap<String,Set<String>>();
		for (Usuari u: users){
			Set<Huma> jugadors = u.getJugadors();
			Set<String> noms = new HashSet<>();
			for (Jugador j : jugadors) if (j.EsPublic()) noms.add(j.getName());		
			info.put(u.getUsername(), noms);		
		}
		
		Set<String> dummys = new HashSet<>();
		for (Dummy d: FactoriaControladors.getInstance().getCtrlDummy().getAll()){
			dummys.add(d.getName());
		}
		
		info.put("Dummys", dummys);
		
		
		InfoUsuarisJugadors ret = new InfoUsuarisJugadors(info);
		return ret;
	}
}
