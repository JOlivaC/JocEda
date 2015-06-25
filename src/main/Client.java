/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import Xarxa.Missatges.Login;
import Xarxa.Servidor.Escoltador;
import Xarxa.Servidor.Sesio;
import Xarxa.Sockets.PaquetSocket;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author JOAN
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("localhost",4000);
        
        Login l = new Login();
        l.Dades.Name = "joan";
        l.Dades.Pass = "oliva";
        PaquetSocket t = new PaquetSocket(s);
        t.Escriure(l);
        

        Scanner in = new Scanner(System.in);
        while (in.nextLine().compareTo("exit") != 0);
    }
}
