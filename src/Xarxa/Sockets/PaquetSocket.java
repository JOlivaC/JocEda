/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Xarxa.Sockets;

import Xarxa.Missatges.Paquet;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author JOAN
 */
public class PaquetSocket extends Socket {
    private ObjectOutputStream out;
    private ObjectInputStream in;
    public PaquetSocket(Socket s) throws IOException{
        super(s.getInetAddress(),s.getPort());
        
        
    }
    public void Escriure(Paquet p) throws IOException{
        out = new ObjectOutputStream(getOutputStream());
         out.writeObject(p);
    }
    
    public Paquet Llegir() throws IOException, ClassNotFoundException{
        in = new ObjectInputStream(getInputStream());
        return (Paquet) in.readObject();
    }
}
