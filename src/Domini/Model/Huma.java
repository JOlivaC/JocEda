/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini.Model;

import java.util.HashSet;
import java.util.Set;

import Comunicacio.Fitxer;

/**
 *
 * @author JOAN
 */

public class Huma extends Jugador{
	private Usuari owner;
    public Huma(){
    	super();
    }
	public Usuari getOwner() {
		return owner;
	}
	public void setOwner(Usuari owner) {
		this.owner = owner;
	}
	
	public boolean EsHuma(){return true;}
    
}
