package Domini.Directoris;

import java.io.File;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import Comunicacio.Fitxer;

public abstract class Directori {
	protected File directori;
	
	public Directori(){
		CrearDirectori();
	}
	public Directori(int clau) throws IOException{
		CrearDirectori(String.valueOf(clau));
	}
	public Directori(String clau) throws IOException{
		CrearDirectori(clau);
	}
	protected abstract String getDirName();
	
	public void CrearDirectori(){
		directori = new File(System.getProperty("user.dir") + File.separator + "Data" + File.separator + getDirName());
		if (!directori.exists()) directori.mkdir();
		else if (!directori.isDirectory()) {
			directori.delete();
			directori.mkdir();
		}
	};
	
	public void CrearDirectori(String Clau) throws IOException{
		directori = new File(System.getProperty("user.dir") + File.separator + "Data" +  getDirName() + Clau);
		if (!directori.exists()) directori.mkdir();
		else if (!directori.isDirectory()) {
			directori.delete();
			directori.mkdir();
		}
	}
	
	public void DestruirDirectori(){
		for (File g:directori.listFiles()) g.delete();
		directori.delete();
	}
	
	public void AfegirFitxer(Fitxer f) throws IOException{
		f.WriteFileInDir(directori.getAbsolutePath());
	}
	
	public String getDir(){return directori.getPath();}
	
	public void CopyAll(Directori d) throws IOException{
		org.apache.commons.io.FileUtils.copyDirectory(d.directori, directori);

	}
	
	
}
