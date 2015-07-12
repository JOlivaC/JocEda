/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Xarxa.Missatges;

import java.io.File;
import java.io.IOException;

import Comunicacio.Fitxer;


/**
 *
 * @author JOAN
 */
public class PenjarJugador extends Paquet {
    public Fitxer F;

    public PenjarJugador(Fitxer F) throws IOException{
        this.F = F;
    }
    public boolean EsPenjarJugador(){return true;}
    public Fitxer getPenjarJugador() throws IOException{
    	return F;
    }
    
}
