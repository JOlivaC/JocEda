/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini.Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JOAN
 */
public class Usuari {
    private String user;
    private String pass;
    private List<Jugador> jugadors;
    public Usuari(){
    	jugadors = new ArrayList<>();
    }
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
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
	
	public void AfegirJugador(Jugador j){
		jugadors.add(0,j);
	}

	
	
}
