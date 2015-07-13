package Domini.Transaccions;

import Actors.Alarmes.AlarmaJugar;
import Domini.Factories.FactoriaControladors;

public class TxEngegarAlarmes {
	public void Executar() throws Exception{
		for (AlarmaJugar a :FactoriaControladors.getInstance().getCtrlAlarma().getAll()){
			if (!a.getPartida().EstaJugada())
			a.Programar();
		}
	}
}
