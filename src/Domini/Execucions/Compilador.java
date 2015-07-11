package Domini.Execucions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Compilador {
        
    public static void main(String[] args) throws IOException {
        Compilador c = new Compilador();
        try {
            File f = c.compilarJugador("/home/jose/Documentos/Games/game/Prueba.cc");
            System.out.println("Jugador compilat: "+f.getAbsolutePath());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    // Enllaça els .o del joc per crear l'executable "Game".
    public void compilarJoc(String ruta) throws IOException, Exception{
        Process p = Runtime.getRuntime().exec(new String[]{"/bin/sh","-c", "g++ -o "+ruta+"/Game "+ruta+"/*.o "+ruta+"/*.o-LINUX64"});
        BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
        String s;
        String e = "";
        while ((s = stdError.readLine()) != null) e += s+"\n";
        if(p.waitFor()!=0) throw new Exception("Error al compilar el joc:\n"+e);
    }
    
    private Exception WriteException(Process p){
    	String msg = "";
    	BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
        Scanner in = new Scanner(stdError);
        while (in.hasNext()){
        	msg += in.nextLine() + "\n";
        }
        return new Exception(msg);
    }

    // Compila el jugador indicat a "ruta" a la mateixa carpeta. Retorna el .o del jugador.
    public File compilarJugador(String ruta) throws FileNotFoundException, Exception{
        File f = new File(ruta);
        validarJugador(f);
        String parent = f.getParent()+ File.separator;
        String fnwe = f.getName().split("\\.")[0];
        
        String exe = "cmd /c g++ -std=c++0x -c -o "+parent+fnwe+".o "+ruta;
        Process p = Runtime.getRuntime().exec(exe);
        if (p.waitFor() != 0) throw WriteException(p);
        
        return new File(parent+fnwe+".o");
        
        

        //while (stdError.)
        //while ((s = stdError.readLine()) != null) e += s+"\n";
        //if(p.waitFor()!=0) throw new Exception("Error al compilar el jugador:\n"+e);
        
        // Comprobar que al executar una partida de prova el joc no es penja.
        // Si es penja, executarJoc retorna excepció.
        /*compilarJoc(f.getParent());
        Executor ex = new Executor();
        ArrayList<String> players = new ArrayList<String>();
        players.add(fnwe);
        ex.executarJoc(players,parent);*/
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
            throw new Exception("Jugador invalid. Comprova que el nom del "
                    + "fitxer es correspon amb el nom indicat al codi.");
    }
}
