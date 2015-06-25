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
    private Socket connexio;
    private CasUsSessio CUSessio;

    
    public Sesio(Socket s){
        connexio = s;
        CUSessio = new CasUsSessio();
        this.setDaemon(true);
    }
    public static Paquet Llegir(Socket s) throws IOException, ClassNotFoundException{
        Paquet Ret = (Paquet) new ObjectInputStream(s.getInputStream()).readObject();
        return Ret;
    }
    public static void Escriure(Socket s,Paquet p) throws IOException{
        new ObjectOutputStream(s.getOutputStream()).writeObject(p);
    }
    public void run() {
            
            boolean end = false;
            while (!end){
                try {
                    Paquet dada;
                    dada = Llegir(connexio);
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
        
        Sesio.Escriure(connexio,R);
    }
    
}
