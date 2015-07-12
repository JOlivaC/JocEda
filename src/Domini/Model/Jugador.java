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

public class Jugador {
    private String name;
    private Fitxer jugador;
    private Usuari owner;
    private Set<Partida> PartidesJugades;
    public Jugador(){
    	PartidesJugades = new HashSet<>();
    }
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Fitxer getJugador() {
		return jugador;
	}
	public void setJugador(Fitxer jugador) {
		this.jugador = jugador;
	}
	public Usuari getOwner() {
		return owner;
	}
	public void setOwner(Usuari owner) {
		this.owner = owner;
	}
    
	public Set<Partida> getPartidesJugades() {
		return PartidesJugades;
	}
	public void setPartidesJugades(Set<Partida> partidesJugades) {
		PartidesJugades = partidesJugades;
	}
    
	public boolean equals(Object other){
		return name.equals(((Jugador)other).name);
	}
}
