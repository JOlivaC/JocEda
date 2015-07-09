package Domini.Directoris;

import java.io.File;
import java.io.IOException;

import Comunicacio.Fitxer;

public abstract class Directori {
	protected File directori;
	
	public Directori(){
		CrearDirectori();
	}
	protected abstract String getDirName();
	
	public void CrearDirectori(){
		directori = new File(System.getProperty("user.dir") + File.separator + getDirName());
	};
	
	public void AfegirFitxer(Fitxer f) throws IOException{
		f.WriteFileInDir(directori.getAbsolutePath());
	}
	
	public String getDir(){return directori.getAbsolutePath();}
}
