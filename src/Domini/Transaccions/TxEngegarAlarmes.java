package Domini.Transaccions;

import Actors.Alarmes.AlarmaJugar;
import Domini.Factories.FactoriaControladors;
import Domini.Model.Partida;

public class TxEngegarAlarmes {
	public void Executar() throws Exception{
		for (Partida p: FactoriaControladors.getInstance().getCtrlPartida().getAll()){
			if (!p.EstaJugada()) {
				AlarmaJugar a = new AlarmaJugar(p.getData(),p.getID());
				a.Programar();
			}
		}
	}
}
