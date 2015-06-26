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
public class PenjarJugadorResponse extends Paquet {
    public Comunicacio.PenjarJugadorResponse PJ = new Comunicacio.PenjarJugadorResponse();

    public PenjarJugadorResponse(boolean valid){
        PJ.valid = valid;
    }
    public boolean EsPenjarJugadorResponse(){return true;}
}
