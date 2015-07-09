/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini.Model;

import java.io.File;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Actors.Alarmes.AlarmaJugar;
import Comunicacio.Fitxer;
import Dades.Factories.HibernateUtil;
import Domini.Fitxers.FitxerJugador;

/**
 *
 * @author JOAN
 */

public class Jugador {
    private String name;
    private Fitxer jugador;
    private Usuari owner;
    private Set<Partida> PartidesJugades;
    
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
    
    
    @SuppressWarnings("deprecation")
	public static void main(String argv[]){
    	
    	
    }
	public Set<Partida> getPartidesJugades() {
		return PartidesJugades;
	}
	public void setPartidesJugades(Set<Partida> partidesJugades) {
		PartidesJugades = partidesJugades;
	}
    
}
