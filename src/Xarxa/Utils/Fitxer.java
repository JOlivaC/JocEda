package Xarxa.Utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;

public class Fitxer implements Serializable {
	private byte[] dades;
	private String nom;
	
	public Fitxer(File f) throws IOException{
		BufferedInputStream in = new BufferedInputStream(new FileInputStream(f));
		dades = new byte[(int)f.length()];
		in.read(dades);
		nom = f.getName();
	}
	
	public File getFile() throws IOException{
		File f = new File(System.getProperty("user.dir") + File.separator + nom);
		BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(f));
		out.write(dades);
		out.close();
		return f;
	}
}
