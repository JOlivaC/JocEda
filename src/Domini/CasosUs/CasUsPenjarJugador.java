/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini.CasosUs;

import Domini.Fitxers.FitxerJugador;
import Domini.Model.Jugador;
import Domini.Model.Usuari;
import Excepcions.FitxerInvalid;

/**
 *
 * @author JOAN
 */
public class CasUsPenjarJugador {
	private Usuari u;
    public CasUsPenjarJugador(Usuari u){}
    public void PenjarJugador(FitxerJugador f) throws FitxerInvalid{
    	 Jugador j = new Jugador();
    	 j.setJugador(f);
    	 j.setName(f.getNomSenseExt());
    	 u.AfegirJugador(j);
    	 
    	 // Guardar U i J, prevenir rollback en cas de nom repetit
    }
}
