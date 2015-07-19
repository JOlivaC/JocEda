package Updater.CasosUs;

import java.io.File;
import java.io.IOException;

import Client.BD.PropietatsServidor;
import Comunicacio.Fitxer;
import Domini.Directoris.Directori;
import Domini.Directoris.DirectoriRelease;
import Updater.Release.ClientJar;

public class CasUsDescarregarJar {
	
	public ClientJar DescarregarJar() throws IOException{
		Directori d = new DirectoriRelease();
		String ruta = d.getDir() + File.separator + "Client.jar";
		PropietatsServidor p = new PropietatsServidor();
		return new ClientJar(p.getVersio(),new Fitxer(new File(ruta)));
	}
}
