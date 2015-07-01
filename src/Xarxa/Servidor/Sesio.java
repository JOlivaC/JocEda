/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Xarxa.Servidor;

import java.io.IOException;

import Dades.Excepcions.NoExisteixPartida;
import Domini.CasosUs.CasUsSessio;
import Excepcions.PartidaNoJugada;
import Xarxa.Missatges.ConsultarClassificacio;
import Xarxa.Missatges.ConsultarClassificacioResponse;
import Xarxa.Missatges.ConsultarResultats;
import Xarxa.Missatges.ConsultarResultatsResponse;
import Xarxa.Missatges.Login;
import Xarxa.Missatges.LoginResponse;
import Xarxa.Missatges.Paquet;
import Xarxa.Missatges.PenjarJugador;
import Xarxa.Missatges.PenjarJugadorResponse;
import Xarxa.Missatges.VisualitzarPartida;
import Xarxa.Missatges.VisualitzarPartidaResponse;
import Xarxa.Sockets.PaquetSocket;

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
                    else if (dada.EsConsultarResultats()) ConsultarResultats(dada.ConsultarResultatsCast());
                    else if (dada.EsConsultarClassificacio()) ConsultarClassificacio(dada.ConsultarClassificacioCast());
                    else if (dada.EsVisualitzarPartida()) VisualitzarPartida(dada.VisualitzarPartidaCast());
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
    private void ConsultarResultats(ConsultarResultats CR) throws IOException{
    	ConsultarResultatsResponse R;
		try {
			R = new ConsultarResultatsResponse(CUSessio.ConsultarResultats());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			R = new ConsultarResultatsResponse(e);
		}
    	connexio.Escriure(R);
    }
    
    private void ConsultarClassificacio(ConsultarClassificacio CC) throws IOException{
    	ConsultarClassificacioResponse R = new ConsultarClassificacioResponse(CUSessio.ConsultarClassificacio());
    	connexio.Escriure(R);
    }
    private void VisualitzarPartida(VisualitzarPartida VP) throws IOException{
    	VisualitzarPartidaResponse R;
		try {
			R = new VisualitzarPartidaResponse(CUSessio.VisualitzarPartida(VP.getID()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			R = new VisualitzarPartidaResponse(e);
		}
    	connexio.Escriure(R);
    }
}
