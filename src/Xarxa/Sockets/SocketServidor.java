package Xarxa.Sockets;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.SocketException;
import java.net.SocketImpl;

public class SocketServidor extends ServerSocket {
	  public SocketServidor(int port) throws IOException {
		super(port);
		// TODO Auto-generated constructor stub
	}

	public PaquetSocket accept() throws IOException {
		  if (isClosed())
		    throw new SocketException("Socket is closed");
		  if (!isBound())
		    throw new SocketException("Socket is not bound yet");
		  
		  PaquetSocket s = new PaquetSocket((SocketImpl) null);
		  implAccept(s);
		  return s;
	  }
}
