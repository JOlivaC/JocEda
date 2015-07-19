package Client.BD;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Propietats {
	private static final String config = "config.ini";
	private static final String PIP = "IP";
	private static final String PPort = "PORT";
	private static final String PVersio = "VERSIO";
	private static final String PRutaFitxer = "RUTAFITXER";
	
	private static final String DefaultIP = "localhost";
	private static final int DefaultPort = 4000;
	private static final int DefaultVersio = 0;
	private static final String DefaultRutaFitxer = "";
	
	private String ip;
	private int port;
	private int versio;
	private String rutafitxer;
	Properties p;
	public Propietats() throws FileNotFoundException, IOException {
		p  = new Properties();
		Load();
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
		
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public int getVersio() {
		return versio;
	}
	public void setVersio(int versio) {
		this.versio = versio;
	}
	public String getRutafitxer() {
		return rutafitxer;
	}
	public void setRutafitxer(String rutafitxer) {
		this.rutafitxer = rutafitxer;
	}
	
	
	public void Save() throws FileNotFoundException, IOException {
		p.setProperty(PIP, this.getIp());
		p.setProperty(PPort, String.valueOf(this.getPort()));
		p.setProperty(PVersio, String.valueOf(this.getVersio()));	
		p.setProperty(PRutaFitxer, this.getRutafitxer());
		p.store(new FileOutputStream(new File(System.getProperty("user.dir") + File.separator + config)),config);
	}
	
	public void Load() throws FileNotFoundException, IOException {
		 try {
			p.load(new FileInputStream(config));
		} catch (FileNotFoundException e) {
			CrearFitxer();
		}
		 
		 this.setIp(p.getProperty(PIP));
		 this.setPort(Integer.valueOf(p.getProperty(PPort)));
		 this.setVersio(Integer.valueOf(p.getProperty(PVersio)));	
		 this.setRutafitxer(p.getProperty(PRutaFitxer));
		 
		 
	}
	
	private void CrearFitxer() throws FileNotFoundException, IOException{
		p.setProperty(PIP, DefaultIP);
		p.setProperty(PPort,String.valueOf(DefaultPort));
		p.setProperty(PVersio,String.valueOf(DefaultVersio));	
		p.setProperty(PRutaFitxer,String.valueOf(DefaultRutaFitxer));
		p.store(new FileOutputStream(new File(System.getProperty("user.dir") + File.separator + config)),config);
	}
	

	
}
