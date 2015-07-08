package Domini.Transaccions;

import Domini.Factories.FactoriaControladors;
import Domini.InterficieBD.CtrlAlarma;
import Excepcions.ErrorPartida;

public class TxJugarPartida {
	private int IDPartida;
	public TxJugarPartida(int IDPartida){this.IDPartida = IDPartida;}
	public void Executar() throws ErrorPartida {
		//TODO
		// Buscar la partida
		//Fer la partida
		// Canviar l'estat de la partida
		// Borrar l'alarma
		CtrlAlarma ctrl = FactoriaControladors.getInstance().getCtrlAlarma();

	}
}
