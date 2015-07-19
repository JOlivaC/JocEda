/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Xarxa.Client;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.SortedSet;

import Updater.Release.ClientJar;
import Comunicacio.Fitxer;
import Comunicacio.InfoCalendariPartida;
import Comunicacio.InfoJugadorRanking;
import Comunicacio.InfoPartida;
import Comunicacio.InfoUsuarisJugadors;
import Excepcions.FitxerInvalid;
import Excepcions.InvalidLogin;

/**
 *
 * @author JOAN
 */
public interface CapaDominiInterface {
	public void Connectar() throws IOException;
    public void Login(String User,String Pass) throws IOException, ClassNotFoundException, InvalidLogin, Exception;
    
    public void EnviarFitxer(File f) throws IOException, ClassNotFoundException, FitxerInvalid, Exception;
    
    public Fitxer EnviarIVisualitzar(File f) throws IOException, ClassNotFoundException, FitxerInvalid, Exception;
    
    public SortedSet<InfoPartida> ConsultarResultats() throws IOException, ClassNotFoundException, Exception;
    
    public  SortedSet<InfoJugadorRanking> ConsultarClassificacio() throws IOException, ClassNotFoundException, Exception;
    
    public Fitxer VisualitzarPartida(int ID) throws IOException, ClassNotFoundException, Exception;
    
    public void Registrarse(String User,String pass) throws Exception;
    
    public SortedSet<InfoCalendariPartida> ConsultarCalendari() throws Exception;
    
    public void Finalitzar() throws Exception;
    
    public boolean CheckUpdate(int versio) throws Exception;
    
    public ClientJar DescarregarUpdate() throws Exception;
    
    public InfoUsuarisJugadors VeureProves() throws Exception;
    
    public Fitxer FerProva(Set<String> jugadors) throws Exception;
    
}
