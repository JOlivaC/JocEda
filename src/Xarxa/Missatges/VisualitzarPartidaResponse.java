package Xarxa.Missatges;

import java.io.File;
import java.io.IOException;

import Comunicacio.Fitxer;

public class VisualitzarPartidaResponse extends Paquet {
	private Fitxer F;

    public VisualitzarPartidaResponse(File F) throws IOException{
        this.F = new Fitxer(F);
    }
    public boolean EsVisualitzarPartidaResponse(){return true;}
    public File getPartida() throws IOException{
    	return F.getFile();
    }
}
