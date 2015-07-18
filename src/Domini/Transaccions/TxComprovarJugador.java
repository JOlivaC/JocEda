package Domini.Transaccions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import Comunicacio.Fitxer;
import Domini.Directoris.DirectoriObjectes;
import Domini.Directoris.DirectoriProvaJugador;
import Domini.Execucions.Compilador;
import Domini.Execucions.Executor;
import Domini.Factories.FactoriaControladors;
import Domini.Model.Dummy;
import Domini.Model.Jugador;

public class TxComprovarJugador {
	private Fitxer j;
	
	public TxComprovarJugador(Fitxer j){
		this.j = j;
	}
	
	public void Executar() throws Exception{
		DirectoriProvaJugador dir = new DirectoriProvaJugador(j.getNomSenseExt());
		Set<Dummy> dummys = FactoriaControladors.getInstance().getCtrlDummy().getAll();
		
		
		if (dummys.size() < 3) throw new Exception("Insuficients Jugadors per fer la prova");
		
		//dir.CopyAll(new DirectoriObjectes());
		dir.AfegirJugador(j);
		
		List<String> jugadors = new ArrayList<String>();
		for (Jugador j: dummys) {
			dir.AfegirFitxer(j.getJugador());
			jugadors.add(j.getName());
		}
		jugadors.add(j.getNomSenseExt());
		
		Compilador c = new Compilador();
		c.compilarJoc(dir.getDir(),new DirectoriObjectes().getDir());
		
		Executor e = new Executor();
		//e.executarJoc(jugadors, dir.getDir());	
		
		dir.DestruirDirectori();
	}
}
