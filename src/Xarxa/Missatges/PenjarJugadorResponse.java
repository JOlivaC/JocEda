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
    public boolean valid;

    public PenjarJugadorResponse(boolean valid){
        this.valid = valid;
    }
    public PenjarJugadorResponse(Exception e) {
		super(e);
	}
	public boolean EsPenjarJugadorResponse(){return true;}
}
