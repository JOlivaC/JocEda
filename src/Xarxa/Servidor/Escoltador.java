/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Xarxa.Servidor;

import Log.LogServidor;
import Xarxa.Sockets.PaquetSocket;
import Xarxa.Sockets.SocketServidor;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author JOAN
 */
public class Escoltador extends Thread {

	private Set<Sesio> Sessions = new HashSet<>();
    private static final int MAX_SESSIONS = 15;
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
	               	if (Sessions.size() < MAX_SESSIONS){
	               		LogServidor.WriteLine("Nova Connexio: " + s.getInetAddress());
	               		Sesio se = new Sesio(s);
	               		Sessions.add(se);
	               		se.start();
	               	}
	               	else s.close();

	        }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        
    }

    
}
