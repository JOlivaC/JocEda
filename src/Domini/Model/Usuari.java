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
    private Set<Huma> jugadors;
    private Huma jugadorActual;
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
	public Set<Huma> getJugadors() {
		return jugadors;
	}
	public void setJugadors(Set<Huma> humas) {
		this.jugadors = humas;
	}
	
	public Set<Huma> getSetJugadors(){
		return new HashSet<Huma>(jugadors);
	}
	
	public void AfegirJugador(Huma j){
		jugadors.add(j);
		jugadorActual = j;
	}
	
	public Huma GetJugadorActual() throws Exception{
		if (jugadors.size() > 0) return jugadorActual;
		else throw new Exception("No hi han jugadors");
	}
	public Huma getJugadorActual() {
		return jugadorActual;
	}
	public void setJugadorActual(Huma jugadorActual) {
		this.jugadorActual = jugadorActual;
	}
	
	public boolean equals(Object o){
		return username.equals(((Usuari) o).username);
	}

	
	
}
