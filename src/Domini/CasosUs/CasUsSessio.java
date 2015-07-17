/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini.CasosUs;

import java.util.SortedSet;

import Comunicacio.Fitxer;
import Comunicacio.InfoCalendariPartida;
import Comunicacio.InfoJugadorRanking;
import Comunicacio.InfoPartida;
import Comunicacio.InfoUsuarisJugadors;
import Domini.Model.Usuari;

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
    public void Penjar(Fitxer f) throws Exception{
    	CasUsPenjarJugador u = new CasUsPenjarJugador(loguejat);
    	u.PenjarJugador(f);	
    }
    
    public  SortedSet<InfoPartida> ConsultarResultats() throws Exception{
    	return new CasUsConsultarResultats().ConsultarResultats();
    }
    
    public  SortedSet<InfoJugadorRanking> ConsultarClassificacio() throws Exception{
    	return new CasUsConsultarClassificacio().ConsultarClassificacio();
    }
    
    public Fitxer VisualitzarPartida(int IDPartida) throws Exception{
    	return new CasUsVisualitzarPartida().VisualitzarPartida(IDPartida);
    }
    
    public SortedSet<InfoCalendariPartida> ConsultarCalendari() throws Exception{
    	return new CasUsConsultarCalendari().ConsultarCalendari();
    }
    
    public InfoUsuarisJugadors ObrirProves() throws Exception{
    	return new CasUsObrirProves().ObrirProves(loguejat);
    }
}
