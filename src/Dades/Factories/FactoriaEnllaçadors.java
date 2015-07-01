package Dades.Factories;

import Dades.Enlla�adors.Enlla�adorAlarma;
import Dades.Enlla�adors.Enlla�adorPartida;

public class FactoriaEnlla�adors {
	private static FactoriaEnlla�adors instance = new FactoriaEnlla�adors();
	public static FactoriaEnlla�adors getInstance(){return instance;}
	
	private Enlla�adorAlarma a = new Enlla�adorAlarma();
	private Enlla�adorPartida p = new Enlla�adorPartida();
	
	public Enlla�adorPartida getEnlla�adorPartida(){return p;}
	public Enlla�adorAlarma getEnlla�adorAlarma(){return a;}
}
