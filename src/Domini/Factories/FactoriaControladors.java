package Domini.Factories;

import Dades.Controladors.TaulaAlarma;
import Domini.InterficieBD.CtrlAlarma;
import Domini.InterficieBD.CtrlJugador;
import Domini.InterficieBD.CtrlPartida;
import Domini.InterficieBD.CtrlResultat;
import Domini.InterficieBD.CtrlUsuari;

public class FactoriaControladors {
	private static FactoriaControladors instance = new FactoriaControladors();
	public static FactoriaControladors getInstance(){return instance;}
	
	public CtrlUsuari getCtrlUsuari(){return null;}
	public CtrlPartida getCtrlPartida(){return null;}
	public CtrlResultat getCtrlResultats(){return null;}
	public CtrlJugador getCtrlJugador(){return null;}
	public CtrlAlarma getCtrlAlarma(){return new TaulaAlarma();}
}
