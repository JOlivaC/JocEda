/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Xarxa.Missatges;

import Domini.Fitxers.FitxerJugador;

/**
 *
 * @author JOAN
 */
public class PenjarJugador extends Paquet {
    public Comunicacio.PenjarJugador PJ = new Comunicacio.PenjarJugador();

    public PenjarJugador(FitxerJugador F){
        PJ.FJ = F;
    }
    public boolean EsPenjarJugador(){return true;}
    
    
}
