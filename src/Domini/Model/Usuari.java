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
    private List<Jugador> jugadors;
    public Usuari(){
    	jugadors = new ArrayList<>();
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
	public List<Jugador> getJugadors() {
		return jugadors;
	}
	public void setJugadors(List<Jugador> jugadors) {
		this.jugadors = jugadors;
	}
	
	public Set<Jugador> getSetJugadors(){
		return new HashSet<Jugador>(jugadors);
	}
	
	public void AfegirJugador(Jugador j){
		jugadors.add(0,j);
	}

	
	
}
