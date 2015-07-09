/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini.CasosUs;

import Comunicacio.Fitxer;
import Domini.Factories.FactoriaControladors;
import Domini.Fitxers.FitxerJugador;
import Domini.Model.Jugador;
import Domini.Model.Usuari;
import Domini.Transaccions.TxCompilarJugador;
import Excepcions.FitxerInvalid;

/**
 *
 * @author JOAN
 */
public class CasUsPenjarJugador {
	private Usuari u;
    public CasUsPenjarJugador(Usuari u){}
    public void PenjarJugador(FitxerJugador f) throws FitxerInvalid{
    	try{
    		TxCompilarJugador t = new TxCompilarJugador(f);
    		t.Executar();
    		Fitxer oo = t.getResultat();
    		Jugador j = new Jugador();
       	 	j.setJugador(oo);
       	 	j.setName(f.getNomSenseExt());
       	 	u.AfegirJugador(j);
       	 	
       	 	FactoriaControladors.getInstance().getCtrlUsuari().Update(u);   	 	
    	}
    	catch (Exception e){
    		throw new FitxerInvalid();
    	}
    }
}
