package Xarxa.Missatges;

import java.io.IOException;

import Comunicacio.Fitxer;

public class PenjarIVisualitzar extends PenjarJugador {
	public PenjarIVisualitzar(Fitxer f) throws IOException{
		 super(f);
	}
	
	public boolean EsPenjarIVisualitzar(){return true;}
	public boolean EsPenjarJugador(){return false;}
}
