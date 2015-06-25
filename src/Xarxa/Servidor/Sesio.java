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
import Xarxa.Sockets.PaquetSocket;
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

    
    public Sesio(Socket s) throws IOException{
        connexio = new PaquetSocket(s);
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
                    else if (dada.EsPenjarJugador()){
                        
                    }
                } catch (IOException | ClassNotFoundException ex) {
                    end = true;
                } 
                           
            }

    }
    
    private void Login(Login l) throws IOException{
        LoginResponse R = new LoginResponse();
        try {
            CUSessio.Login(l.Dades.Name, l.Dades.Pass);
            R.LR.Autoritzat = true;
        } catch (Exception ex) {
            R.LR.Autoritzat = false;
        }
        
        connexio.Escriure(R);
    }
    
}
