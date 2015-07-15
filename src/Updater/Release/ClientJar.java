package Updater.Release;

import java.io.File;
import java.io.Serializable;

import Comunicacio.Fitxer;

public class ClientJar implements Serializable {
	private int Versio;
	private Fitxer jar;
	public ClientJar(){}
	public ClientJar(int Versio,Fitxer jar){
		this.Versio = Versio;
		this.jar = jar;
	}
	public int getVersio() {
		return Versio;
	}
	public void setVersio(int versio) {
		Versio = versio;
	}
	public Fitxer getJar() {
		return jar;
	}
	public void setJar(Fitxer jar) {
		this.jar = jar;
	}
	
	
	
	
}
