package Xarxa.Missatges;

import java.io.File;
import java.io.IOException;

import Comunicacio.Fitxer;
import Domini.Fitxers.FitxerResultat;

public class VisualitzarPartidaResponse extends Paquet {
	private FitxerResultat F;

    public VisualitzarPartidaResponse(FitxerResultat F) throws IOException{
        this.F = F;
    }
    public boolean EsVisualitzarPartidaResponse(){return true;}
    public FitxerResultat getPartida() throws IOException{
    	return F;
    }
}
