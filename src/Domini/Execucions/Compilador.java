package Domini.Execucions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Compilador {
        
    public static void main(String[] args) throws IOException {
        Compilador c = new Compilador();
        try {
            //c.compilarJugador("/home/jose/Documentos/Games/game/Demo.cc");
            c.compilarJoc("/home/jose/Documentos/Games/game");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void compilarJoc(String ruta) throws IOException, Exception{
        Process p = Runtime.getRuntime().exec(new String[]{"/bin/sh","-c", "g++ -o "+ruta+"/Game "+ruta+"/*.o"});
        BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
        String s;
        String e = "";
        while ((s = stdError.readLine()) != null) e += s+"\n";
        if(!e.equals("")) throw new Exception("Error al compilar el joc:\n"+e);
    }

    public void compilarJugador(String ruta) throws FileNotFoundException, Exception{
        File f = new File(ruta);
        validarJugador(f);
        String parent = f.getParent()+"/";
        if (parent == null) parent = "/";
        String fnwe = f.getName().split("\\.")[0];
        Process p = Runtime.getRuntime().exec("g++ -c -o "+parent+fnwe+".o "+ruta);
        BufferedReader stdError = new BufferedReader(new
                InputStreamReader(p.getErrorStream()));
        String s;
        String e = "";
        while ((s = stdError.readLine()) != null) e += s+"\n";
        if(!e.equals("")) throw new Exception("Error al compilar el jugador:\n"+e);
    }

    private void validarJugador(File f) throws FileNotFoundException, IOException, Exception {
        BufferedReader r = new BufferedReader(new FileReader(f));
        String filename = f.getName().split("\\.")[0];
        String playername = null;
        String l;
        while(((l = r.readLine()) != null) && playername==null){
            String[] aux = l.split(" ");
            if (aux[0].equals("#define") && aux[1].equals("PLAYER_NAME"))
                playername = aux[2];
        }
        r.close();
        if(playername==null || (!playername.equals(filename))) 
            throw new Exception("Jugador no vàlid. Comprova que el nom del "
                    + "fitxer es correspon amb el nom indicat al codi.");
        
    }
}
