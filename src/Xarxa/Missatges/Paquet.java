/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Xarxa.Missatges;

import java.io.Serializable;

/**
 *
 * @author JOAN
 */
public abstract class Paquet implements Serializable {
    public boolean EsLogin(){return false;}
    public boolean EsFinalitzar(){return false;}
    public boolean EsPenjarJugador(){return false;}
    public boolean EsLoginResponse(){return false;}
    public boolean EsPenjarJugadorResponse(){return false;}
    
    
    
    public Login LoginCast(){return (Login) this;}
    public Finalitzar FinalitzarCast(){return (Finalitzar) this;}
    public PenjarJugador PenjarJugadorCast(){return (PenjarJugador) this;}
    public LoginResponse LoginResponseCast(){return (LoginResponse) this;}
    public PenjarJugadorResponse PenjarJugadorResponseCast(){return (PenjarJugadorResponse) this;}
    
}
