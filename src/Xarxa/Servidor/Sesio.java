/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Xarxa.Servidor;

import java.io.IOException;

import Domini.CasosUs.CasUsSessio;
import Excepcions.FitxerInvalid;
import Log.LogServidor;
import Updater.CasosUs.CasUsCheck;
import Updater.CasosUs.CasUsDescarregarJar;
import Xarxa.Missatges.*;
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
        connexio.setSoTimeout(1000*60*5);
        this.setDaemon(true);
    }

    public void run() {
            
            boolean end = false;
            while (!end){
                try {
                    Paquet dada;
                    dada = connexio.Llegir();
                    if (dada.EsLogin()) Login(dada.LoginCast());           
                    else if (dada.EsFinalitzar()) end = true;
                    else if (dada.EsPenjarJugador()) Penjar(dada.PenjarJugadorCast());
                    else if (dada.EsConsultarResultats()) ConsultarResultats(dada.ConsultarResultatsCast());
                    else if (dada.EsConsultarClassificacio()) ConsultarClassificacio(dada.ConsultarClassificacioCast());
                    else if (dada.EsVisualitzarPartida()) VisualitzarPartida(dada.VisualitzarPartidaCast());
                    else if (dada.EsRegistrarse()) Registrarse(dada.RegistrarseCast());
                    else if (dada.EsCheckUpdate()) CheckUpdate(dada.CheckUpdateCast());
                    else if (dada.EsConsultarCalendari()) ConsultarCalendari();
                    else if (dada.EsDescarregarJar()) DescarregarJar();
                    
                } catch (Exception ex) {
                    end = true;
                } 
                           
            }
            
            try {
            	LogServidor.WriteLine("Connexio Tancada: " + connexio.getInetAddress());
				connexio.close();	
			} catch (IOException e) {
				LogServidor.WriteLine("Error al tancar la connexio de: " + connexio.getInetAddress());
			}
            

    }
    
    private void Penjar(PenjarJugador PJ) throws IOException {
    	PenjarJugadorResponse R;
    	try {
			CUSessio.Penjar(PJ.getPenjarJugador());
			R = new PenjarJugadorResponse(true);
		} catch (FitxerInvalid e) {
			R = new PenjarJugadorResponse(false);
		} catch (Exception e) {
			R = new PenjarJugadorResponse(e);
		}
    	
    	connexio.Escriure(R);
    }
    
    private void Login(Login l) throws IOException{
        LoginResponse R = new LoginResponse();
        try {
            CUSessio.Login(l.User, l.Pass);
            R.autoritzat = true;
        } catch (Exception ex) {
            R.autoritzat = false;
        }
        
        connexio.Escriure(R);
    }
    private void ConsultarResultats(ConsultarResultats CR) throws IOException{
    	ConsultarResultatsResponse R;
		try {
			R = new ConsultarResultatsResponse(CUSessio.ConsultarResultats());
		} catch (Exception e) {
			R = new ConsultarResultatsResponse(e);
		}
    	connexio.Escriure(R);
    }
    private void Registrarse(Registrarse R) throws IOException{
    	RegistrarseResponse Res;
    	try {
    		CUSessio.Regisrarse(R.getUser(), R.getPass());
    		Res = new RegistrarseResponse();
    	} 
    	catch(Exception e){
    		Res = new RegistrarseResponse(e);
    	}
    	connexio.Escriure(Res);
    }
    
    private void ConsultarClassificacio(ConsultarClassificacio CC) throws Exception{
    	ConsultarClassificacioResponse R = new ConsultarClassificacioResponse(CUSessio.ConsultarClassificacio());
    	connexio.Escriure(R);
    }
    private void VisualitzarPartida(VisualitzarPartida VP) throws IOException{
    	VisualitzarPartidaResponse R;
		try {
			R = new VisualitzarPartidaResponse(CUSessio.VisualitzarPartida(VP.getID()));
		} catch (Exception e) {
			R = new VisualitzarPartidaResponse(e);
		}
    	connexio.Escriure(R);
    }
    
    private void ConsultarCalendari() throws IOException{
    	ConsultarCalendariResponse R;
    	
    	try {
			R = new ConsultarCalendariResponse(CUSessio.ConsultarCalendari());
		} catch (Exception e) {
			R = new ConsultarCalendariResponse(e);
		}
    	
    	connexio.Escriure(R);
    }
    
    private void CheckUpdate(CheckUpdate P) throws IOException{
    	CasUsCheck C = new CasUsCheck();
    	BooleanResponse R = new BooleanResponse();
    	R.setResult(C.CheckUpdate(P.getVersio()));
    	connexio.Escriure(R);
    }
    
    private void DescarregarJar() throws IOException{
    	CasUsDescarregarJar C = new CasUsDescarregarJar();
    	connexio.Escriure(new DescarregarJarResponse(C.DescarregarJar()));
    }
}
