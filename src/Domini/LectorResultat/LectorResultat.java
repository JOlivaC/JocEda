package Domini.LectorResultat;

import java.io.File;

import Domini.Model.Resultat;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LectorResultat {

	public InfoResultat Llegir(File f) throws FileNotFoundException, IOException, Exception{
		BufferedReader r = new BufferedReader(new FileReader(f));
                String l;
                while((l = r.readLine()) != null && !l.split(" ")[0].equals("names"));
                if ((l = r.readLine()) != null) throw new Exception("El fitxer no és un fitxer de Battle Royale vàlid.");
                while((l = r.readLine()) != null && !l.equals("round 100"));
                while((l = r.readLine()) != null && !l.split(" ")[0].equals("score"));
                String[] aux = l.split(" ");
                //InfoJugador p1 = new InfoJugador();
		return null;
	}
}
