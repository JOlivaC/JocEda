package Xarxa.Missatges;

import java.io.IOException;

import Comunicacio.Fitxer;


public class VisualitzarPartidaResponse extends Paquet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Fitxer F;

    public VisualitzarPartidaResponse(Fitxer F) throws IOException{
        this.F = F;
    }
    public VisualitzarPartidaResponse(Exception e) {
		super(e);
	}
	public boolean EsVisualitzarPartidaResponse(){return true;}
    public Fitxer getPartida() throws IOException{
    	return F;
    }
}
