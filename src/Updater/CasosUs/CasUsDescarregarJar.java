package Updater.CasosUs;

import java.io.File;
import java.io.IOException;

import Comunicacio.Fitxer;
import Updater.Release.ClientJar;

public class CasUsDescarregarJar {
	private static final String ruta = System.getProperty("user.dir") + File.separator + "Release" + File.separator + "Client.jar";
	public ClientJar DescarregarJar() throws IOException{
		return new ClientJar(1,new Fitxer(new File(ruta)));
	}
}
