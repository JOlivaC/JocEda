package Domini.Execucions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Random;

public class Executor {
    
    final private static String[] maps = {"akamatsu.cnf","default.cnf","kitano.cnf","nanahara.cnf",
        "chigusa.cnf","kiriyama.cnf","nakagawa.cnf","utsumi.cnf"};
    
    public static void main(String[] args) throws IOException {
        Executor e = new Executor();
        try {
            File f = e.executarJoc("Prueba","Dummy","Dummy","Dummy","/home/jose/Documentos/Games/game");
            System.out.println(f.getAbsolutePath());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public File executarJoc(String p1, String p2, String p3, String p4, String ruta) throws IOException, Exception{
        File f = new File(ruta);
        String map = maps[new Random().nextInt(8)];
        Process p = Runtime.getRuntime().exec("./Game "+p1+" "+p2+" "+p3+" "+p4,new String[0],f);

        // Escriure entrada (fitxer del mapa).
        System.out.println(ruta+"/"+map);
        BufferedReader entrada = new BufferedReader(new FileReader(ruta+"/"+map));
        BufferedWriter stdInput = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));
        stdInput.write(entrada.toString());
        stdInput.flush();
        stdInput.close();
        entrada.close();
        
        
        // Guardar sortida (resultat).
        BufferedWriter resultat  = new BufferedWriter(new FileWriter(ruta+"/game.br"));
        BufferedReader stdOutput = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String l;
        while((l = stdOutput.readLine())!=null) resultat.write(l);
        resultat.close();
        
        // Comprovar errors.
        BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
        String e = "";
        while ((l = stdError.readLine()) != null) e += l+"\n";
        if(!e.equals("")) throw new Exception("S'ha produït un error durant l'execució del joc:\n"+e);
        
        return new File(ruta+"/game.br");
    }
}
