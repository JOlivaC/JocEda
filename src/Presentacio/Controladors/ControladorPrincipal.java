/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacio.Controladors;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.SortedSet;

import Comunicacio.InfoCalendariPartida;
import Comunicacio.InfoJugadorRanking;
import Comunicacio.InfoPartida;
import Comunicacio.InfoUsuarisJugadors;
import Excepcions.FitxerInvalid;
import Excepcions.InvalidLogin;
import Excepcions.NoHiHaFitxer;
import Presentacio.Comuns.Finestra;
import Presentacio.Comuns.PanellContenidor;
import Updater.Client.ControladorUpdater;
import Xarxa.Client.CapaDominiInterface;
import Xarxa.Client.Solicitant;

/**
 *
 * @author JOAN
 */
public class ControladorPrincipal {
    private Presentacio.LoginView.Login VistaLogin;
    private Presentacio.PenjarView.Penjar VistaPenjar;
    private Presentacio.MenuPrincipalView.MenuPrincipal VistaMenu;
    private Presentacio.Resultats.ResultatsView VistaResultats;
    private Presentacio.Classificacio.ClassificacioView VistaRanking;
    private Presentacio.RegisterView.Registrar VistaRegistrar;
    private Presentacio.Calendari.CalendariView VistaCalendari;
    private Presentacio.Prova.ProvaView VistaProva;
    private CapaDominiInterface Domini;
    private Finestra Vista;
    private GestorContextual Gestor;
    
    public ControladorPrincipal() {
    	Gestor = new GestorContextual();
        Vista = new Finestra();
        Vista.addWindowListener(new EscoltadorFinestra());
        Domini = new Solicitant();
        MostrarLogin();   
        try {
			Domini.Connectar();
		} catch (IOException e) {
			VistaLogin.MostraMsg("Servidor offline");
		}
        
        try {
			ControladorUpdater u = new ControladorUpdater(Domini);
			u.Iniciar();
			if (u.getResult()) VistaLogin.MostraMsg("La Versio s'acaba d'actualitzar, reinicia el programa");
			else VistaLogin.MostraMsg("La versio esta actualitzada");
			
		} catch (Exception e) {
			VistaLogin.MostraMsg(e.getMessage());
		}
    }
    
    private void MostrarLogin(){
    	 VistaLogin = new Presentacio.LoginView.Login(new LoginOK(),new Registrarse());
         CanviarContext("Login",VistaLogin);
    }
    private void MostrarRegistrar(){
   	 VistaRegistrar = new Presentacio.RegisterView.Registrar(new RegistrarOK(),new Retrocedir());
   	 CanviarContext("Registrar-se",VistaRegistrar);
   }
    private void MostrarPenjar(){
    	 VistaPenjar = new Presentacio.PenjarView.Penjar(new FitxerOK(),new Retrocedir());
    	 CanviarContext("Penjar Jugador",VistaPenjar);
    }
    private void MostrarMenu(){
    	VistaMenu = new Presentacio.MenuPrincipalView.MenuPrincipal(new Penjar(), new Resultats(), new Ranking(),new Calendari(),new VeureProves());
    	CanviarContext("Menu",VistaMenu);
    }
    private void MostrarResultats( SortedSet<InfoPartida> Info){
    	VistaResultats = new Presentacio.Resultats.ResultatsView(new Retrocedir(),new VisualitzarPartida(),Info);
    	CanviarContext("Resultats",VistaResultats);
    }
    private void MostrarRanking(SortedSet<InfoJugadorRanking> info){
    	VistaRanking = new Presentacio.Classificacio.ClassificacioView(new Retrocedir(),info);
    	CanviarContext("Classificacio",VistaRanking);
    }
    private void MostrarCalendari(SortedSet<InfoCalendariPartida> info){
    	VistaCalendari = new Presentacio.Calendari.CalendariView(new Retrocedir(),4,info);
    	CanviarContext("Calendari",VistaCalendari);
    }
    private void MostrarProves(InfoUsuarisJugadors info){
    	VistaProva = new Presentacio.Prova.ProvaView(new Retrocedir(), new FerProva());
    	VistaProva.SetDades(info.getInfo());
    	CanviarContext("Partides de Prova",VistaProva);
    }
    public void VeureResultats(){

    		try {
				MostrarResultats(Domini.ConsultarResultats());
			} catch (Exception e) {
				
			}
    		


    }
    public void Registrar(String user,String pass){
    	try {
			Domini.Registrarse(user, pass);
			MostrarLogin();
		} catch (Exception e) {
			VistaRegistrar.MostraMsg(e.getMessage());
		}
    	
    }
    public void VisualitzarPartida(int IDPartida){
    	try {
			new Client.VisualitzarPartida.VisualitzarPartida().Visualitzar(Domini.VisualitzarPartida(IDPartida));
		} catch ( Exception e) {
			VistaResultats.MostraMsg(e.getMessage());
		}
    }
    public void VeureCalendari(){
    	try {
			MostrarCalendari(Domini.ConsultarCalendari());
		} catch (Exception e) {
			
		}
    }
    public void VeureRanking(){
    	try {
			
			MostrarRanking(Domini.ConsultarClassificacio());
		} catch (Exception e) {
			
		}
    	
    	
    }
    
    public void VisualitzarProves(){
		try {
			MostrarProves(Domini.VeureProves());
		} catch (Exception e) {
			
		}
   	
    }
    
    public void FerProva(Set<String> jugadors){
    	try {
    		new Client.VisualitzarPartida.VisualitzarPartida().Visualitzar(Domini.FerProva(jugadors));
		} catch (Exception e) {
			VistaProva.MostraMsg(e.getMessage());
		}
    }
    public void Login(String User,String Pass){
        try {
            Domini.Login(User, Pass);
            MostrarMenu();
        } catch (IOException ex) {
        	VistaLogin.MostraMsg("Error de Xarxa");
        } catch (ClassNotFoundException ex) {
            
        } catch (InvalidLogin ex) {
            VistaLogin.MostraMsg("Login Incorrecte");
        } catch (Exception e) {
			VistaLogin.MostraMsg(e.getMessage());
		}
    }
    public void Finalitzar(){
    	try {
			Domini.Finalitzar();
		} catch (Exception e) {
			
		}
    }
    
    public void PenjarFitxer(){
    	try {
    		File f = VistaPenjar.getFitxer();
    		Domini.EnviarFitxer(f);
    		MostrarMenu();
    	}
    	catch (NoHiHaFitxer e){
    		VistaPenjar.MostraMsg("No hi ha fitxer");
    	} catch (ClassNotFoundException e) {
		} catch (IOException e) {
			VistaPenjar.MostraMsg("Error de xarxa");
		} catch (FitxerInvalid e) {
			VistaPenjar.MostraMsg("Fitxer Invalid");
		} catch (Exception e) {
			VistaPenjar.MostraMsg(e.getMessage());
		}
    }
    
    private void CanviarContext(String titol,PanellContenidor Panell){
    	Panell.setTitol(titol);
    	Vista.CanviarContext(titol, Panell);
    	Vista.pack();
    	Gestor.NouContext(Panell);
    }
    
    public void Retrocedir(){
    	PanellContenidor p = Gestor.Retrocedir();
    	Vista.CanviarContext(p.getTitol(), p);
    }
    
    
    
    
    private class LoginOK implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Login(VistaLogin.getUserName(),VistaLogin.getPassword());
        }
        
    }
    
    private class Penjar implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			MostrarPenjar();
			
		}
    	
    }
    private class Registrarse implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			MostrarRegistrar();
			
		}
    	
    }
    private class RegistrarOK implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			Registrar(VistaRegistrar.getUserName(), VistaRegistrar.getPassword());
		}
    	
    }
    private class Resultats implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			VeureResultats();
			
		}
    	
    }
    private class Calendari implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			VeureCalendari();
		}
    	
    }
    private class Ranking implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			VeureRanking();
			
		}
    	
    }
    private class FitxerOK implements ActionListener{
    	public void actionPerformed(ActionEvent e){
    		PenjarFitxer();
    	}
    }
    
    private class VisualitzarPartida implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			VisualitzarPartida(VistaResultats.getLastID());
		}
    	
    }
    
    private class VeureProves implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			VisualitzarProves();
			
		}
    	
    }
    
    private class FerProva implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			FerProva(VistaProva.getJugadors());		
		}
    	
    }
    
    private class Retrocedir implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			Retrocedir();
		}
    	
    }
    
    private class EscoltadorFinestra implements WindowListener{

		@Override
		public void windowActivated(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowClosed(WindowEvent arg0) {
			Finalitzar();
			
		}

		@Override
		public void windowClosing(WindowEvent arg0) {
			Finalitzar();
			
		}

		@Override
		public void windowDeactivated(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeiconified(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowIconified(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowOpened(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}
    	
    }
    
}
