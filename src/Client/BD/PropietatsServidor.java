package Client.BD;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class PropietatsServidor {
	private static final String config = "Serverconfig.ini";
	private static final String PVersio = "VERSIO";
	

	private static final int DefaultVersio = 0;
	
	private int versio;
	Properties p;
	public PropietatsServidor() throws FileNotFoundException, IOException {
		p  = new Properties();
		Load();
	}

	public int getVersio() {
		return versio;
	}
	public void setVersio(int versio) {
		this.versio = versio;
	}
	
	public void Save() throws FileNotFoundException, IOException {
		p.setProperty(PVersio, String.valueOf(this.getVersio()));	
		p.store(new FileOutputStream(new File(System.getProperty("user.dir") + File.separator + config)),config);
	}
	
	public void Load() throws FileNotFoundException, IOException {
		 try {
			p.load(new FileInputStream(config));
		} catch (FileNotFoundException e) {
			CrearFitxer();
		}
		 
		 this.setVersio(Integer.valueOf(p.getProperty(PVersio)));	
		 
		 
		 
	}
	
	private void CrearFitxer() throws FileNotFoundException, IOException{
		p.setProperty(PVersio,String.valueOf(DefaultVersio));	
		p.store(new FileOutputStream(new File(System.getProperty("user.dir") + File.separator + config)),config);
	}
	

	
}
