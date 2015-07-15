/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Xarxa.Client;

import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.SortedSet;

import Client.BD.Propietats;
import Comunicacio.Fitxer;
import Comunicacio.InfoCalendariPartida;
import Comunicacio.InfoJugadorRanking;
import Comunicacio.InfoPartida;
import Excepcions.FitxerInvalid;
import Excepcions.InvalidLogin;
import Updater.Release.ClientJar;
import Xarxa.Missatges.LoginResponse;
import Xarxa.Sockets.PaquetSocket;

/**
 *
 * @author JOAN
 */
public class Solicitant implements CapaDominiInterface {
    private PaquetSocket s;
    
    public Solicitant(){
         s = new PaquetSocket();
        
    }
    
    public void Connectar() throws IOException{
    	 Propietats p = new Propietats();
    	 s.connect(new InetSocketAddress(p.getIp(),p.getPort()),5000);
    }
    
    @Override
    public void Login(String User,String Pass) throws Exception{
         s.Escriure(new Xarxa.Missatges.Login(User,Pass));
    	 LoginResponse r = s.Llegir().LoginResponseCast();
    	 if (! r.autoritzat) throw new InvalidLogin();   
    }
    

	@Override
	public void EnviarFitxer(File f) throws Exception{
        s.Escriure(new Xarxa.Missatges.PenjarJugador(new Fitxer(f)));
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
	
	public Fitxer VisualitzarPartida(int ID) throws Exception{
		s.Escriure(new Xarxa.Missatges.VisualitzarPartida(ID));
		return s.Llegir().VisualitzarPartidaResponseCast().getPartida();
	}

	@Override
	public void Registrarse(String User, String pass) throws Exception {
		s.Escriure(new Xarxa.Missatges.Registrarse(User, pass));
		s.Llegir();
	}
	
	
	public void Finalitzar() throws Exception {
		s.Escriure(new Xarxa.Missatges.Finalitzar());
	}

	@Override
	public SortedSet<InfoCalendariPartida> ConsultarCalendari() throws Exception {
		s.Escriure(new Xarxa.Missatges.ConsultarCalendari());
		return s.Llegir().ConsultarCalendariResponseCast().getInfo();
	}

	@Override
	public boolean CheckUpdate(int versio) throws Exception {
		s.Escriure(new Xarxa.Missatges.CheckUpdate(versio));
		return s.Llegir().BooleanResponseCast().isResult();
	}

	@Override
	public ClientJar DescarregarUpdate() throws Exception {
		s.Escriure(new Xarxa.Missatges.DescarregarJar());
		return s.Llegir().DescarregarJarResponseCast().getJar();
	}
    
   
}
