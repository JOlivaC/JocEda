/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini.Model;

import java.util.HashSet;
import java.util.Set;

import Comunicacio.InfoJugadorPartida;
import Comunicacio.InfoPartida;
import Domini.Fitxers.FitxerResultat;
import Domini.Model.EstatPartida.IEstatPartida;

/**
 *
 * @author JOAN
 */
public class Partida {
	private int ID;
    private IEstatPartida Estat;
    private Set<ResultatJugador> Resultat;
    private Set<Jugador> Participants;
    private FitxerResultat PartidaResultant;
    
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
	public FitxerResultat getPartidaResultant() {
		return PartidaResultant;
	}
	public void setPartidaResultant(FitxerResultat partidaResultant) {
		PartidaResultant = partidaResultant;
	}
	public boolean EstaJugada(){
		// TODO 
		return false;
	}
    
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
    
    
}
