/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Xarxa.Missatges;

import java.io.File;
import java.io.IOException;

import Xarxa.Utils.Fitxer;
import Domini.Fitxers.FitxerJugador;

/**
 *
 * @author JOAN
 */
public class PenjarJugador extends Paquet {
    public Fitxer F;

    public PenjarJugador(File F) throws IOException{
        this.F = new Fitxer(F);
    }
    public boolean EsPenjarJugador(){return true;}
    public File getPenjarJugador() throws IOException{
    	return F.getFile();
    }
    
}
