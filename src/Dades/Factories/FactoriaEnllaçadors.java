package Dades.Factories;

import Dades.Enllaçadors.EnllaçadorAlarma;
import Dades.Enllaçadors.EnllaçadorFitxer;
import Dades.Enllaçadors.EnllaçadorPartida;

public class FactoriaEnllaçadors {
	private static FactoriaEnllaçadors instance = new FactoriaEnllaçadors();
	public static FactoriaEnllaçadors getInstance(){return instance;}
	
	private EnllaçadorAlarma a = new EnllaçadorAlarma();
	private EnllaçadorPartida p = new EnllaçadorPartida();
	private EnllaçadorFitxer f = new EnllaçadorFitxer();
	
	public EnllaçadorPartida getEnllaçadorPartida(){return p;}
	public EnllaçadorAlarma getEnllaçadorAlarma(){return a;}
	public EnllaçadorFitxer getEnllaçadorFitxer(){return f;}
}
