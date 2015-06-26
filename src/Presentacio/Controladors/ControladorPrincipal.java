/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacio.Controladors;

import Excepcions.InvalidLogin;
import Presentacio.Comuns.Finestra;
import Xarxa.Client.CapaDominiInterface;
import Xarxa.Client.Solicitant;
import Xarxa.Missatges.Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JOAN
 */
public class ControladorPrincipal {
    private Presentacio.LoginView.Login VistaLogin;
    private CapaDominiInterface Domini;
    private Finestra Vista;
    
    public ControladorPrincipal() throws IOException{
        Domini = new Solicitant();
        Vista = new Finestra();
        VistaLogin = new Presentacio.LoginView.Login(new LoginOK());
        Vista.CanviarContext("Login", VistaLogin);  
    }
    public void Login(String User,String Pass){
        try {
            Domini.Login(User, Pass);
        } catch (IOException ex) {
            
        } catch (ClassNotFoundException ex) {
            
        } catch (InvalidLogin ex) {
            
        }
    }
    
    
    
    
    
    private class LoginOK implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Login(VistaLogin.getUserName(),VistaLogin.getPassword());
        }
        
    }
}
