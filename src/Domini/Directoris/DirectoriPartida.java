package Domini.Directoris;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import Comunicacio.Fitxer;

public class DirectoriPartida extends Directori {
	private Set<File> jugadors;
	public DirectoriPartida(){
		super();
		jugadors = new HashSet<>();
	}
	
	public DirectoriPartida(int id) throws IOException {
		super(id);
		jugadors = new HashSet<>();
	}

	public DirectoriPartida(String clau) throws IOException {
		super(clau);
		jugadors = new HashSet<>();
	}

	private static final String DirName = "Partida";
	@Override
	protected String getDirName() {
		return DirName;
	}

	public void AfegirJugador(Fitxer j) throws IOException{
		String path = super.directori.getAbsolutePath();
		String loc = File.separator + j.getNomSenseExt();
		String ext = ".o";
		String Ruta = path + loc + ext;
		jugadors.add(j.WriteFile(Ruta));
	}
	
	public void Natejar(){
		for (File j : jugadors) j.delete();
	}
	
	
}
