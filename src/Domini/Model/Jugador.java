/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini.Model;

import java.io.File;

import Domini.Fitxers.FitxerJugador;

/**
 *
 * @author JOAN
 */
public class Jugador {
	private int ID;
    private String name;
    private FitxerJugador jugador;
    private Usuari owner;
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public FitxerJugador getJugador() {
		return jugador;
	}
	public void setJugador(FitxerJugador jugador) {
		this.jugador = jugador;
	}
    
    
    
    
}
