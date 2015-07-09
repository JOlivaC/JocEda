/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini.CasosUs;

import java.util.SortedSet;

import Comunicacio.InfoJugadorRanking;
import Comunicacio.InfoPartida;
import Domini.Fitxers.FitxerJugador;
import Domini.Fitxers.FitxerResultat;
import Domini.Model.Usuari;
import Excepcions.FitxerInvalid;

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
    public void Regisrarse(String user,String pass) throws Exception
    {
    	new CasUsRegistrarse().Registrarse(user, pass);
    }
    public void Penjar(FitxerJugador f) throws FitxerInvalid{
    	CasUsPenjarJugador u = new CasUsPenjarJugador(loguejat);
    	u.PenjarJugador(f);	
    }
    
    public  SortedSet<InfoPartida> ConsultarResultats() throws Exception{
    	return new CasUsConsultarResultats().ConsultarResultats();
    }
    
    public  SortedSet<InfoJugadorRanking> ConsultarClassificacio(){
    	return new CasUsConsultarClassificacio().ConsultarClassificacio();
    }
    
    public FitxerResultat VisualitzarPartida(int IDPartida) throws Exception{
    	return new CasUsVisualitzarPartida().VisualitzarPartida(IDPartida);
    }
}
