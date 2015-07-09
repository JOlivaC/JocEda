/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Xarxa.Missatges;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author JOAN
 */
public abstract class Paquet implements Serializable {
	public Paquet(){}
	
	 private Exception excepcio;
	 public void Throw() throws Exception{
		 if (excepcio != null) throw excepcio;
	 }
	public Paquet(Exception e){
		excepcio = e;
	}
    public boolean EsLogin(){return false;}
    public boolean EsFinalitzar(){return false;}
    public boolean EsPenjarJugador(){return false;}
    public boolean EsLoginResponse(){return false;}
    public boolean EsPenjarJugadorResponse(){return false;}
    public boolean EsConsultarResultats(){return false;}
    public boolean EsConsultarResultatsResponse(){return false;}
    public boolean EsConsultarClassificacio(){return false;}
    public boolean EsConsultarClassificacioResponse(){return false;}
    public boolean EsVisualitzarPartida(){return false;}
    public boolean EsVisualitzarPartidaResponse(){return false;}
    public boolean EsRegistrarse(){return false;}
    public boolean EsRegistrarseResponse(){return false;}
    
    
    
    public Login LoginCast(){return (Login) this;}
    public Finalitzar FinalitzarCast(){return (Finalitzar) this;}
    public PenjarJugador PenjarJugadorCast(){return (PenjarJugador) this;}
    public LoginResponse LoginResponseCast(){return (LoginResponse) this;}
    public PenjarJugadorResponse PenjarJugadorResponseCast(){return (PenjarJugadorResponse) this;}
    public ConsultarResultats ConsultarResultatsCast(){return (ConsultarResultats) this;}
    public ConsultarResultatsResponse ConsultarResultatsResponseCast(){return (ConsultarResultatsResponse) this;}
    public ConsultarClassificacio ConsultarClassificacioCast(){return (ConsultarClassificacio) this;}
    public ConsultarClassificacioResponse ConsultarClassificacioResponseCast(){return (ConsultarClassificacioResponse) this;}
    public VisualitzarPartida VisualitzarPartidaCast(){return (VisualitzarPartida) this;}
    public VisualitzarPartidaResponse VisualitzarPartidaResponseCast(){return (VisualitzarPartidaResponse) this;}
    public Registrarse RegistrarseCast(){return (Registrarse) this;}
    public RegistrarseResponse RegistrarseResponseCast(){return (RegistrarseResponse) this;}
    
   
    
    
    
}
