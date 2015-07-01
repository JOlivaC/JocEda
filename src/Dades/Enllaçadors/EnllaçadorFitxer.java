package Dades.Enlla�adors;

import Comunicacio.Fitxer;
import Dades.Acces.AccesFitxer;

public class Enlla�adorFitxer {
	private AccesFitxer ACFitxer = Dades.Factories.FactoriaAccessos.getInstance().getAccesFitxer();
	public Fitxer get(String name) throws Exception{
		Dades.Tipus.Fitxer f = ACFitxer.get(name);
		return new Comunicacio.Fitxer(f.getNom(),f.getDades());
	}
	
	public void insert(Fitxer f) throws Exception{
		Dades.Tipus.Fitxer F = new Dades.Tipus.Fitxer(f.getNom(),f.getDades());
		ACFitxer.Insert(F);
	}
}
