package Domini.Directoris;

import java.io.File;
import java.io.IOException;

import Comunicacio.Fitxer;

public class DirectoriCompilacioJugador extends Directori{

	private static final String DirName = "CompilacioJugador";

	private File cc;
	@Override
	protected String getDirName() {
		return DirName;
	}
	
	public void AfegirFitxer(Fitxer f) throws IOException{
		String path = super.directori.getAbsolutePath();
		String loc =  File.separator + f.getNomSenseExt();
		String ext = ".cc";
		String Ruta = path + loc + ext;
		cc = f.WriteFile(Ruta);
	}
	public Fitxer BuscarResultat() throws Exception{
		//TODO
		return null;
	}
	public String getDirFitxer(){
		return cc.getPath();
	}
	
	public void Natejar(){
		cc.delete();
	}


	
}
