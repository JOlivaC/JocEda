/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Xarxa.Client;

import Domini.Fitxers.FitxerJugador;
import Excepcions.FitxerInvalid;
import Excepcions.InvalidLogin;
import Xarxa.Missatges.Login;
import Xarxa.Missatges.LoginResponse;
import Xarxa.Missatges.Paquet;
import Xarxa.Sockets.PaquetSocket;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author JOAN
 */
public class Solicitant {
    private PaquetSocket s;
    
    public Solicitant() throws IOException{
        //llegir ip i port d'algun lloc
        Socket s = new Socket("localhost",4000);
        this.s = new PaquetSocket(s);
    }
    
    public void Login(String User,String Pass) throws IOException, ClassNotFoundException, InvalidLogin{
        s.Escriure(new Xarxa.Missatges.Login(User,Pass));
        LoginResponse r = s.Llegir().LoginResponseCast();
        if (! r.LR.Autoritzat) throw new InvalidLogin();   
    }
    
    public void EnviarFitxer(FitxerJugador FJ) throws IOException, ClassNotFoundException, FitxerInvalid{
        s.Escriure(new Xarxa.Missatges.PenjarJugador(FJ));
        if (!s.Llegir().PenjarJugadorResponseCast().PJ.valid) throw new FitxerInvalid();
    }
}
