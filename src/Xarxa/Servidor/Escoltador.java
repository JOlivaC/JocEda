/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Xarxa.Servidor;

import Xarxa.Sockets.PaquetSocket;
import Xarxa.Sockets.SocketServidor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JOAN
 */
public class Escoltador extends Thread {

    
    public Escoltador(){
        setDaemon(true);
    }
    

    @Override
    public void run() {
    	SocketServidor SS;
		try {
			SS = new SocketServidor(4000);
			for (;;){         	    
	               	PaquetSocket s = SS.accept();
	                System.out.print("Nova Connexio\n");
	                new Sesio(s).start();

	        }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        
    }

    
}
