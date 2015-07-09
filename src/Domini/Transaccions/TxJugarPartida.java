package Domini.Transaccions;

import Domini.Factories.FactoriaControladors;
import Domini.InterficieBD.CtrlAlarma;
import Domini.InterficieBD.CtrlPartida;
import Domini.Model.Partida;
import Excepcions.ErrorPartida;

public class TxJugarPartida {
	private Partida p;
	public TxJugarPartida(Partida p){this.p = p;}
	public void Executar() throws Exception {
		FerPartida();
		CanviarEstatPartida();
		CtrlAlarma ctrl = FactoriaControladors.getInstance().getCtrlAlarma();
		ctrl.Delete(p.getID());
		
		CtrlPartida ctrlp = FactoriaControladors.getInstance().getCtrlPartida();
		ctrlp.Update(p);
	}
	
	private void FerPartida(){
		//TODO
	}
	private void CanviarEstatPartida(){
		p.Acabar();
	}
}
