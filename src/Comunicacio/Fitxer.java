package Comunicacio;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;

public class Fitxer extends Tipus {
	private byte[] dades;
	private String nom;
	
	public Fitxer(File f) throws IOException{
		BufferedInputStream in = new BufferedInputStream(new FileInputStream(f));
		dades = new byte[(int)f.length()];
		in.read(dades);
		nom = f.getName();
		
		in.close();
	}
	public Fitxer(String nom,byte[] dades){
		this.nom = nom;
		this.dades = dades;
	}
	
	public byte[] getDades(){return dades;}
	
	public File getFile() throws IOException{
		File f = new File(System.getProperty("user.dir") + File.separator + nom);
		BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(f));
		out.write(dades);
		out.close();
		return f;
	}
	public String getNomSenseExt(){
		return stripExtension(nom);
	}
	
	
	public String getNom(){
		return nom;
	}
	
	private static String stripExtension (String str) {
        if (str == null) return null;
        int pos = str.lastIndexOf(".");
        if (pos == -1) return str;
        return str.substring(0, pos);
    }
	
}
