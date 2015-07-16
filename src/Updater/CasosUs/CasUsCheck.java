package Updater.CasosUs;

import java.io.FileNotFoundException;
import java.io.IOException;

import Client.BD.PropietatsServidor;


public class CasUsCheck {
	
	public boolean CheckUpdate(int versio) throws FileNotFoundException, IOException{
		return CalUpdatejar(versio);
	}
	private boolean CalUpdatejar(int versio) throws FileNotFoundException, IOException{
		PropietatsServidor p = new PropietatsServidor();
		return (versio != p.getVersio());
	}
}
