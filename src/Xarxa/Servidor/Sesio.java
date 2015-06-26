/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Xarxa.Servidor;

import Domini.CasosUs.CasUsSessio;
import Xarxa.Missatges.Finalitzar;
import Xarxa.Missatges.Login;
import Xarxa.Missatges.LoginResponse;
import Xarxa.Missatges.Paquet;
import Xarxa.Missatges.PenjarJugador;
import Xarxa.Missatges.PenjarJugadorResponse;
import Xarxa.Sockets.PaquetSocket;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JOAN
 */
public class Sesio extends Thread {
    private PaquetSocket connexio;
    private CasUsSessio CUSessio;

    
    public Sesio(PaquetSocket s) throws IOException{
        connexio = s;
        CUSessio = new CasUsSessio();
        this.setDaemon(true);
    }

    public void run() {
            
            boolean end = false;
            while (!end){
                try {
                    Paquet dada;
                    dada = connexio.Llegir();
                    if (dada.EsLogin()) Login(dada.LoginCast());
                    
                    else if (dada.EsFinalitzar()){
                        
                    }
                    else if (dada.EsPenjarJugador()) Penjar(dada.PenjarJugadorCast());
                } catch (IOException | ClassNotFoundException ex) {
                    end = true;
                } 
                           
            }

    }
    
    private void Penjar(PenjarJugador PJ) throws IOException{
    	PenjarJugadorResponse R = new PenjarJugadorResponse(true);
    	CUSessio.Penjar(PJ.getPenjarJugador());
    	System.out.print("Fitxer Rebut\n");
    	connexio.Escriure(R);
    }
    
    private void Login(Login l) throws IOException{
        LoginResponse R = new LoginResponse();
        try {
            CUSessio.Login(l.User, l.Pass);
            R.autoritzat = true;
            System.out.print("Login Successful\n");
        } catch (Exception ex) {
            R.autoritzat = false;
            System.out.print("Login Failed\n");
        }
        
        connexio.Escriure(R);
    }
    
}
