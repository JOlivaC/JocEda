/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Xarxa.Client;

import Domini.Fitxers.FitxerJugador;
import Excepcions.FitxerInvalid;
import Excepcions.InvalidLogin;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author JOAN
 */
public interface CapaDominiInterface {
    public void Login(String User,String Pass) throws IOException, ClassNotFoundException, InvalidLogin;
    
    public void EnviarFitxer(File f) throws IOException, ClassNotFoundException, FitxerInvalid;
    
}
