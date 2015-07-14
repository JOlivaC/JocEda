/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini.Model;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author JOAN
 */
public class Usuari {
    private String username;
    private String pass;
    private Set<Huma> humas;
    private Huma jugadorActual;
    public Usuari(){
    	humas = new HashSet<>();
    }
	public Usuari(String user, String pass) {
		humas = new HashSet<>();
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
	public Set<Huma> getJugadors() {
		return humas;
	}
	public void setJugadors(Set<Huma> humas) {
		this.humas = humas;
	}
	
	public Set<Huma> getSetJugadors(){
		return new HashSet<Huma>(humas);
	}
	
	public void AfegirJugador(Huma j){
		humas.add(j);
		jugadorActual = j;
	}
	
	public Huma GetJugadorActual() throws Exception{
		if (humas.size() > 0) return jugadorActual;
		else throw new Exception("No hi han jugadors");
	}
	public Huma getJugadorActual() {
		return jugadorActual;
	}
	public void setJugadorActual(Huma jugadorActual) {
		this.jugadorActual = jugadorActual;
	}

	
	
}
