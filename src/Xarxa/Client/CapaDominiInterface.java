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

import java.io.File;
import java.io.IOException;
import java.util.SortedSet;

/**
 *
 * @author JOAN
 */
public interface CapaDominiInterface {
    public void Login(String User,String Pass) throws IOException, ClassNotFoundException, InvalidLogin;
    
    public void EnviarFitxer(File f) throws IOException, ClassNotFoundException, FitxerInvalid;
    
    public SortedSet<InfoPartida> ConsultarResultats() throws IOException, ClassNotFoundException;
    
    public  SortedSet<InfoJugadorRanking> ConsultarClassificacio() throws IOException, ClassNotFoundException;
    
    public File VisualitzarPartida(int ID) throws IOException, ClassNotFoundException;
}
