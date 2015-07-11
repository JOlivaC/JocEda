package Domini.Factories;

import Dades.Controladors.Alarma;
import Dades.Controladors.Jugador;
import Dades.Controladors.Partida;
import Dades.Controladors.Resultat;
import Dades.Controladors.Usuari;
import Domini.InterficieBD.CtrlAlarma;
import Domini.InterficieBD.CtrlJugador;
import Domini.InterficieBD.CtrlPartida;
import Domini.InterficieBD.CtrlResultat;
import Domini.InterficieBD.CtrlUsuari;

public class FactoriaControladors {
	private static FactoriaControladors instance = new FactoriaControladors();
	public static FactoriaControladors getInstance(){return instance;}
	
	private static Usuari cu = new Usuari();
	private static Partida cp = new Partida();
	private static Resultat cr = new Resultat();
	private static Jugador cj = new Jugador();
	private static Alarma ca = new Alarma();
	
	public CtrlUsuari getCtrlUsuari(){return  cu;}
	public CtrlPartida getCtrlPartida(){return cp;}
	public CtrlResultat getCtrlResultats(){return cr;}
	public CtrlJugador getCtrlJugador(){return cj;}
	public CtrlAlarma getCtrlAlarma(){return ca;}
}
