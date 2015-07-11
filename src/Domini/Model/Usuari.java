/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini.Model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author JOAN
 */
public class Usuari {
    private String username;
    private String pass;
    private Set<Jugador> jugadors;
    private Jugador jugadorActual;
    public Usuari(){
    	jugadors = new HashSet<>();
    }
	public Usuari(String user, String pass) {
		jugadors = new HashSet<>();
		this.username = user;
		this.pass = pass;

	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String user) {
		this.username = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public Set<Jugador> getJugadors() {
		return jugadors;
	}
	public void setJugadors(Set<Jugador> jugadors) {
		this.jugadors = jugadors;
	}
	
	public Set<Jugador> getSetJugadors(){
		return new HashSet<Jugador>(jugadors);
	}
	
	public void AfegirJugador(Jugador j){
		jugadors.add(j);
		jugadorActual = j;
	}
	
	public Jugador GetJugadorActual() throws Exception{
		if (jugadors.size() > 0) return jugadorActual;
		else throw new Exception("No hi han jugadors");
	}
	public Jugador getJugadorActual() {
		return jugadorActual;
	}
	public void setJugadorActual(Jugador jugadorActual) {
		this.jugadorActual = jugadorActual;
	}

	
	
}
