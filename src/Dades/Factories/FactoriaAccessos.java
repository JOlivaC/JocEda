package Dades.Factories;

import Dades.Acces.AccesAlarma;
import Dades.Acces.AccesFitxer;
import Dades.Acces.AccesPartida;

public class FactoriaAccessos {
	private static FactoriaAccessos instance = new FactoriaAccessos();
	public static FactoriaAccessos getInstance(){return instance;}
	
	private AccesAlarma a = new AccesAlarma();
	private AccesFitxer f = new AccesFitxer();
	private AccesPartida p = new AccesPartida();
	
	public AccesAlarma getAccesAlarma(){return a;}
}
