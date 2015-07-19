/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini.CasosUs;

import Comunicacio.Fitxer;
import Domini.Factories.FactoriaControladors;
import Domini.Model.Huma;
import Domini.Model.Jugador;
import Domini.Model.Usuari;
import Domini.Transaccions.TxCompilarJugador;
import Domini.Transaccions.TxComprovarJugador;

/**
 *
 * @author JOAN
 */
public class CasUsPenjarJugador {
	private Usuari u;
    public CasUsPenjarJugador(Usuari u){this.u = u;}
    public Fitxer PenjarJugador(Fitxer f) throws Exception{
    	Fitxer resultat;
    	Fitxer oo;
    	try{
    		TxCompilarJugador t = new TxCompilarJugador(f);
    		t.Executar();
    		oo = t.getResultat();
    	}
    	catch (Exception e){
    		throw new Exception("El jugador no compila");
    		
    	}
    	
    	try{
    		TxComprovarJugador t = new TxComprovarJugador(oo);
    		t.Executar();
    		resultat = t.getResult();
    		
    	}
    	catch (Exception e){
    		throw new Exception("El jugador compila pero no passa la prova");
    	}
    	
    	Huma j = new Huma();
    	
    	if (!FactoriaControladors.getInstance().getCtrlJugador().Exists(f.getNomSenseExt())){
    		j.setJugador(oo);
       	 	j.setName(f.getNomSenseExt());
       	 	j.setOwner(u);
       	 	u.AfegirJugador(j);
       	 	FactoriaControladors.getInstance().getCtrlUsuari().Update(u);   
    	}
    	else {
    		Jugador k = FactoriaControladors.getInstance().getCtrlJugador().get(f.getNomSenseExt());
    		if (k.EsHuma()){
    			Huma h = (Huma)k;
    			if (h.getOwner().equals(u)){
        			k.setJugador(oo);
        			FactoriaControladors.getInstance().getCtrlHuma().Update(h);
        		}
    			else throw new Exception("El nom del jugador ja existeix");
    		}
    		
    		else throw new Exception("El nom del jugador ja existeix");
    	}
    	
    	return resultat;
    
    }
}
