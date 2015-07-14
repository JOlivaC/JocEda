/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini.Model;

import java.util.HashSet;
import java.util.Set;

import Comunicacio.Fitxer;
import Comunicacio.InfoJugadorPartida;
import Comunicacio.InfoPartida;

/**
 *
 * @author JOAN
 */
public class Partida implements Comparable<Object>{
	private int ID;
    private int Estat;
    private Set<ResultatJugador> Resultat;
    private Set<Usuari> Participants;
    private Fitxer PartidaResultant;
    
    public Partida(){
    	Resultat = new HashSet<>();
    	Participants = new HashSet<>();
    }
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public Set<ResultatJugador> getResultat() {
		return Resultat;
	}
	public void setResultat(Set<ResultatJugador> resultat) {
		Resultat = resultat;
	}
	public Fitxer getPartidaResultant() {
		return PartidaResultant;
	}
	public void setPartidaResultant(Fitxer partidaResultant) {
		PartidaResultant = partidaResultant;
	}
	public boolean EstaJugada(){
		return Estat == 1;
	}
	
	public int getEstat(){return Estat;}
	
    
	public InfoPartida getInfo(){
		InfoPartida ret = new InfoPartida();
		ret.setIDPartida(this.ID);
		Set<InfoJugadorPartida> IJ = new HashSet<>();
		for (ResultatJugador RJ: Resultat){
			IJ.add(RJ.getInfo());
		}
		ret.setJugadors(IJ);
		
		return ret;
	}
	public void Acabar(){
		Estat = 1;
	}
	public Set<Usuari> getParticipants() {
		return Participants;
	}
	public void setParticipants(Set<Usuari> participants) {
		Participants = participants;
	}
	public void setEstat(int estat) {
		Estat = estat;
	}
	@Override
	public int compareTo(Object arg0) {
		return Integer.compare(this.ID,((Partida)arg0).ID);
	}
	
	public String toString(){
		return String.valueOf(ID);
	}
    
    
}
