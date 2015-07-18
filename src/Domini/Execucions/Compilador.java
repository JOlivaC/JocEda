package Domini.Execucions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Compilador {
        

    
    public void compilarJoc(String ruta,String Objectes) throws IOException, Exception{
    	String exe = "cmd /c g++ -o " + ruta + File.separator + "Game " 
    			+ ruta + File.separator + "*.o" + " " 
    			+ Objectes + File.separator + "*.o";
    	//new String[]{"/bin/sh","-c", "g++ -o "+ruta+"/Game "+ruta+"/*.o "+ruta+"/*.o-LINUX64"}
        Process p = Runtime.getRuntime().exec(exe);
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
        in.close();
        return new Exception(msg);
        
    }

    
    public File compilarJugador(String ruta,String Headers) throws FileNotFoundException, Exception{
        File f = new File(ruta);
        validarJugador(f);
        String parent = f.getParent()+ File.separator;
        String fnwe = f.getName().split("\\.")[0];
        
        String exe = "cmd /c g++ -I " + Headers + " -std=c++0x -c -o "+parent+fnwe+".o "+ruta;
        Process p = Runtime.getRuntime().exec(exe);
        if (p.waitFor() != 0) throw WriteException(p);
        
        return new File(parent+fnwe+".o");
        

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
