package Domini.Transaccions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import Comunicacio.Fitxer;
import Domini.Directoris.DirectoriMapes;
import Domini.Directoris.DirectoriObjectes;
import Domini.Directoris.DirectoriProvaJugador;
import Domini.Execucions.Compilador;
import Domini.Execucions.Executor;
import Domini.Factories.FactoriaControladors;
import Domini.Model.Dummy;
import Domini.Model.Huma;
import Domini.Model.Jugador;

public class TxComprovarJugador {
	private Fitxer j;
	private Fitxer result;
	public TxComprovarJugador(Fitxer j){
		this.j = j;
	}
	public Fitxer getResult(){return result;}
	
	public void Executar() throws Exception{
		Set<Dummy> dummys = FactoriaControladors.getInstance().getCtrlDummy().getAll();
		Set<Jugador> participants = new HashSet<>();
		
		if (dummys.size() < 3) throw new Exception("Insuficients Jugadors per fer la prova");
		
		
		Iterator<Dummy>  it = dummys.iterator();
		int i = 0;
		while (it.hasNext() && i < 3){
			Dummy d = it.next();
			participants.add(d);
			i++;
		}
		Jugador prova = new Huma();
		prova.setJugador(j);
		prova.setName(j.getNomSenseExt());
		participants.add(prova);
		
		TxFerPartida tx = new TxFerPartida(participants,"Prova" + j.getNomSenseExt());
		tx.Executar();
		result = tx.getResultat();
		
	}
}
