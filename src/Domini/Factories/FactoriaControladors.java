package Domini.Factories;

import Dades.Controladors.Alarma;
import Dades.Controladors.Dummy;
import Dades.Controladors.Huma;
import Dades.Controladors.Lliga;
import Dades.Controladors.Partida;
import Dades.Controladors.Resultat;
import Dades.Controladors.Usuari;
import Domini.InterficieBD.CtrlAlarma;
import Domini.InterficieBD.CtrlDummy;
import Domini.InterficieBD.CtrlHuma;
import Domini.InterficieBD.CtrlLliga;
import Domini.InterficieBD.CtrlPartida;
import Domini.InterficieBD.CtrlResultat;
import Domini.InterficieBD.CtrlUsuari;

public class FactoriaControladors {
	private static FactoriaControladors instance = new FactoriaControladors();
	public static FactoriaControladors getInstance(){return instance;}
	
	private static Usuari cu = new Usuari();
	private static Partida cp = new Partida();
	private static Resultat cr = new Resultat();
	private static Huma cj = new Huma();
	private static Alarma ca = new Alarma();
	private static Dummy cd = new Dummy();
	private static Lliga cl = new Lliga();
	
	public CtrlUsuari getCtrlUsuari(){return  cu;}
	public CtrlPartida getCtrlPartida(){return cp;}
	public CtrlResultat getCtrlResultats(){return cr;}
	public CtrlHuma getCtrlHuma(){return cj;}
	public CtrlAlarma getCtrlAlarma(){return ca;}
	public CtrlDummy getCtrlDummy(){return cd;}
	public CtrlLliga getCtrlLliga(){return cl;}
}
