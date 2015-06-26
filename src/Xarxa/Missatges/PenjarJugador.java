/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Xarxa.Missatges;

import java.io.File;

import Domini.Fitxers.FitxerJugador;

/**
 *
 * @author JOAN
 */
public class PenjarJugador extends Paquet {
    public File F;

    public PenjarJugador(File F){
        this.F = F;
    }
    public boolean EsPenjarJugador(){return true;}
    
    
}
