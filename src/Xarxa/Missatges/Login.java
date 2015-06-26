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
    public String User;
    public String Pass;

    public Login(){}
    public Login(String Name,String Pass){
        User = Name;
        Pass = Pass;
    }
    public boolean EsLogin(){return true;}
    
    
    
}
