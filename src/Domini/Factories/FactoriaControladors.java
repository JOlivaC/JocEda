package Domini.Factories;

import Domini.InterficieBD.CtrlPartida;
import Domini.InterficieBD.CtrlUsuari;

public class FactoriaControladors {
	private static FactoriaControladors instance = new FactoriaControladors();
	public static FactoriaControladors getInstance(){return instance;}
	
	public CtrlUsuari getCtrlUsuari(){return null;}
	public CtrlPartida getCtrlPartida(){return null;}
}
