package Domini.LectorResultat;

import java.io.File;

import Comunicacio.InfoJugadorPartida;
import Presentacio.Controladors.ControladorPrincipal;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LectorResultat {
    
    public static void main(String[] args) throws IOException {
        LectorResultat lr = new LectorResultat();
        File f = new File("/home/jose/Documentos/Games/game/game.br");
        try {
            InfoResultat ir = lr.Llegir(f);
            System.out.print(ir.toString());
        } catch (Exception ex) {
            Logger.getLogger(LectorResultat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public InfoResultat Llegir(File f) throws FileNotFoundException, IOException, Exception{
            BufferedReader r = new BufferedReader(new FileReader(f));
            String l;
            String[] names = new String[0];
            String[] score = new String[0];
            while((l = r.readLine()) != null){
                String[] aux = l.split(" ");
                if(aux[0].equals("names")) names = aux;
                if(aux[0].equals("score")) score = aux;
            }
            if (names.length==0 || score.length==0)
                throw new Exception("El fitxer no és un fitxer de Battle Royale vàlid.");

            InfoResultat info = new InfoResultat(4);
            for (int i=1; i<=4; ++i){
                InfoJugadorPartida inf = new InfoJugadorPartida(names[i],Integer.parseInt(score[i]));
                info.addInfoJugador(inf);
            }
            info.ordenar();
            return info;
    }
}
