/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini.CasosUs;

import java.io.IOException;
import java.util.SortedSet;

import Comunicacio.InfoJugadorRanking;
import Comunicacio.InfoPartida;
import Dades.Excepcions.NoExisteixPartida;
import Domini.Fitxers.FitxerJugador;
import Domini.Fitxers.FitxerResultat;
import Domini.LectorResultat.LectorResultat;
import Domini.Model.Usuari;
import Excepcions.PartidaNoJugada;

/**
 *
 * @author JOAN
 */
public class CasUsSessio {
	private Usuari loguejat;
    public void Login(String User,String Pass) throws Exception
    {
        loguejat = new CasUsLogin().Login(User, Pass);    
    }
    
    public void Penjar(FitxerJugador f){
    	LectorResultat LR = new LectorResultat();
    	try {
			System.out.printf(LR.Llegir(f.getFile()).toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
    
    public  SortedSet<InfoPartida> ConsultarResultats(){
    	return new CasUsConsultarResultats().ConsultarResultats();
    }
    
    public  SortedSet<InfoJugadorRanking> ConsultarClassificacio(){
    	return new CasUsConsultarClassificacio().ConsultarClassificacio();
    }
    
    public FitxerResultat VisualitzarPartida(int IDPartida) throws IOException, PartidaNoJugada, NoExisteixPartida{
    	return new CasUsVisualitzarPartida().VisualitzarPartida(IDPartida);
    }
}
