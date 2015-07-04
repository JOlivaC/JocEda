package Dades.Factories;

import Dades.Enlla�adors.Enlla�adorAlarma;
import Dades.Enlla�adors.Enlla�adorFitxer;
import Dades.Enlla�adors.Enlla�adorParticipants;
import Dades.Enlla�adors.Enlla�adorPartida;

public class FactoriaEnlla�adors {
	private static FactoriaEnlla�adors instance = new FactoriaEnlla�adors();
	public static FactoriaEnlla�adors getInstance(){return instance;}
	
	private Enlla�adorAlarma a = new Enlla�adorAlarma();
	private Enlla�adorPartida p = new Enlla�adorPartida();
	private Enlla�adorFitxer f = new Enlla�adorFitxer();
	private Enlla�adorParticipants pa = new Enlla�adorParticipants();
	
	public Enlla�adorPartida getEnlla�adorPartida(){return p;}
	public Enlla�adorAlarma getEnlla�adorAlarma(){return a;}
	public Enlla�adorFitxer getEnlla�adorFitxer(){return f;}
	public Enlla�adorParticipants getEnlla�adorParticipants(){return pa;}
}
