package Domini.Model;

import java.util.HashSet;
import java.util.Set;

import Comunicacio.Fitxer;

public abstract class Jugador {
	private String name;
    private Fitxer jugador;
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

    
	public Set<Partida> getPartidesJugades() {
		return PartidesJugades;
	}
	public void setPartidesJugades(Set<Partida> partidesJugades) {
		PartidesJugades = partidesJugades;
	}
    
	public boolean equals(Object other){
		return name.equals(((Jugador)other).name);
	}
	
	public boolean EsDummy(){return false;}
	public boolean EsHuma(){return false;}
}
