/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Xarxa.Missatges;

import java.io.Serializable;

/**
 *
 * @author JOAN
 */
public class Login extends Paquet {
    public Comunicacio.Login Dades = new Comunicacio.Login();


    public Login(){}
    public Login(String Name,String Pass){
        Dades.Name = Name;
        Dades.Pass = Pass;
    }
    public boolean EsLogin(){return true;}
    
    
    
}
