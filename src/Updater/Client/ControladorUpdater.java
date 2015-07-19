package Updater.Client;

import java.io.FileNotFoundException;
import java.io.IOException;

import Client.BD.Propietats;
import Updater.Release.ClientJar;
import Xarxa.Client.CapaDominiInterface;

public class ControladorUpdater {
	private CapaDominiInterface domini;
	Propietats p;
	private boolean result;
	public ControladorUpdater(CapaDominiInterface dom) throws FileNotFoundException, IOException{
		domini = dom;
		p = new Propietats();
		result = false;
	}
	
	public void Iniciar() throws Exception{
		boolean MustUpdate = domini.CheckUpdate(LlegirVersio());
		if (MustUpdate){
			Update(domini.DescarregarUpdate());
		}
	}
	
	private int LlegirVersio() throws FileNotFoundException, IOException{
		return p.getVersio();
	}
	
	private void Update(ClientJar j) throws IOException{
		j.getJar().WriteFileInDir(System.getProperty("user.dir"));
		p.setVersio(j.getVersio());
		p.Save();
		result = true;
	}
	
	public boolean getResult(){
		return result;
	}
}
