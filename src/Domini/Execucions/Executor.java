package Domini.Execucions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Executor {
    
    class ThreadStdErr extends Thread {
        
        private InputStream is;
        private String s;
        private boolean acabar = false;

        ThreadStdErr(InputStream i){
            is = i;
        }

        @Override
        public void run(){
            s = " ";
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String line;
            try {
                while(!acabar)
                    while (br.ready() && (line = br.readLine()) != null) s += line;
                br.close();
                isr.close();
                is.close();
                //System.out.println("Acaba ThreadStdErr");
            } catch (IOException ex) {
                Logger.getLogger(Executor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        public String getErr(){
            return s;
        }
        
        public void acaba(){
            acabar = true;
        }
    }
    
    class ThreadStdIn extends Thread {
        
        private OutputStream os;
        private String s;
        
        ThreadStdIn(OutputStream o, String in){
            os = o;
            s = in;
        }
        
        @Override
        public void run(){
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);
            try {
                bw.write(s);
                bw.close();
                //System.out.println("Acaba ThreadStdIn");
            } catch (IOException ex) {
                Logger.getLogger(Executor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    class ThreadStdOut extends Thread {
        
        private InputStream is;
        private String ruta;
        private boolean acabar = false;

        ThreadStdOut(InputStream i, String file){
            is = i;
            ruta = file;
        }
        
        @Override
        public void run(){
            try {
                BufferedWriter resultat  = new BufferedWriter(new FileWriter(ruta));
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);
                String line;
                while(!acabar)
                    while (br.ready() && (line = br.readLine()) != null) resultat.write(line+"\n");
                resultat.close();
                br.close();
                isr.close();
                is.close();
                //System.out.println("Acaba ThreadStdOut");
            } catch (IOException ex) {
                Logger.getLogger(Executor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        public void acaba(){
            acabar = true;
        }
    }
    
    final private static long timeout = 5;
    
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
        // Guardar mapa a un string.
        //System.out.println(ruta+"/"+map);
        BufferedReader entrada = new BufferedReader(new FileReader(ruta+"/"+map));
        String l;
        String fitxer = "";
        while((l=entrada.readLine())!=null) fitxer += l+"\n";
        entrada.close();
        
        // Executar procés.
        Process p = Runtime.getRuntime().exec(ruta+"/./Game "+p1+" "+p2+" "+p3+" "+p4);

        // Crear threads.
        ThreadStdIn stdIn = new ThreadStdIn(p.getOutputStream(),fitxer);
        ThreadStdOut stdOut = new ThreadStdOut(p.getInputStream(),ruta+"/game.br");
        ThreadStdErr stdErr = new ThreadStdErr(p.getErrorStream());
        
        // Executar threads.
        stdIn.start();
        stdOut.start();
        stdErr.start();
        
        // Comprovar si l'execució acaba correctament.
        if(!p.waitFor(timeout,TimeUnit.SECONDS)){
            stdOut.acaba();
            stdErr.acaba();
            throw new Exception("L'execució ha tardat més de "+timeout+" segons.\nMissatges d'error:\n"+stdErr.getErr());
        }
        stdOut.acaba();
        stdErr.acaba();
        if(p.exitValue()!=0){
            throw new Exception("S'ha produït un error durant l'execució del joc.\nMissatges d'error:\n"+stdErr.getErr()
                    +"\nExit value: "+p.exitValue());
        }
            
        return new File(ruta+"/game.br");
    }
}
