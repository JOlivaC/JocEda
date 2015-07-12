/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Xarxa.Client;

import Comunicacio.InfoJugadorRanking;
import Comunicacio.InfoPartida;
import Domini.Fitxers.FitxerJugador;
import Excepcions.FitxerInvalid;
import Excepcions.InvalidLogin;
import Xarxa.Missatges.Login;
import Xarxa.Missatges.LoginResponse;
import Xarxa.Missatges.Paquet;
import Xarxa.Sockets.PaquetSocket;

import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.SortedSet;

/**
 *
 * @author JOAN
 */
public class Solicitant implements CapaDominiInterface {
    private PaquetSocket s;
    
    public Solicitant() throws IOException{
         s = new PaquetSocket("localhost",4000);
    }
    
    @Override
    public void Login(String User,String Pass) throws Exception{
         s.Escriure(new Xarxa.Missatges.Login(User,Pass));
    	 LoginResponse r = s.Llegir().LoginResponseCast();
    	 if (! r.autoritzat) throw new InvalidLogin();   
    }
    

	@Override
	public void EnviarFitxer(File f) throws Exception{
        s.Escriure(new Xarxa.Missatges.PenjarJugador(new FitxerJugador(f)));
        if (!s.Llegir().PenjarJugadorResponseCast().valid) throw new FitxerInvalid();
	}
	
	public SortedSet<InfoPartida> ConsultarResultats() throws Exception {
		s.Escriure(new Xarxa.Missatges.ConsultarResultats());
		return s.Llegir().ConsultarResultatsResponseCast().getInfo();
	}
	
	public  SortedSet<InfoJugadorRanking> ConsultarClassificacio() throws Exception{
		s.Escriure(new Xarxa.Missatges.ConsultarClassificacio());
		return s.Llegir().ConsultarClassificacioResponseCast().getInfo();
	}
	
	public File VisualitzarPartida(int ID) throws Exception{
		s.Escriure(new Xarxa.Missatges.VisualitzarPartida(ID));
		return s.Llegir().VisualitzarPartidaResponseCast().getPartida().getFile();
	}

	@Override
	public void Registrarse(String User, String pass) throws Exception {
		s.Escriure(new Xarxa.Missatges.Registrarse(User, pass));
		s.Llegir();
	}
	
	public void Finalitzar() throws Exception {
		s.Escriure(new Xarxa.Missatges.Finalitzar());
	}
    
   
}
