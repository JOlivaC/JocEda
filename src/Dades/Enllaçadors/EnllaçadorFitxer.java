package Dades.Enllaçadors;

import Comunicacio.Fitxer;
import Dades.Acces.AccesFitxer;
import Dades.Claus.PKFitxer;

public class EnllaçadorFitxer {
	private AccesFitxer ACFitxer = Dades.Factories.FactoriaAccessos.getInstance().getAccesFitxer();
	public Fitxer get(String name) throws Exception{
		Dades.Tipus.Fitxer f = (Dades.Tipus.Fitxer) ACFitxer.get(new PKFitxer(name));
		return new Comunicacio.Fitxer(f.getNom(),f.getDades());
	}
	
	public void insert(Fitxer f) throws Exception{
		Dades.Tipus.Fitxer F = new Dades.Tipus.Fitxer(f.getNom(),f.getDades());
		ACFitxer.Insert(F);
	}
}
