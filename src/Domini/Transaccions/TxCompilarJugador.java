package Domini.Transaccions;

import java.io.File;

import Comunicacio.Fitxer;
import Domini.Directoris.DirectoriCompilacioJugador;
import Domini.Execucions.Compilador;

public class TxCompilarJugador {
	private Fitxer cc;
	private Fitxer object;
	public TxCompilarJugador(Fitxer cc){
		this.cc = cc;
	}
	
	public Fitxer getResultat(){
		return object;
	}
	
	public void Executar() throws Exception{
		DirectoriCompilacioJugador dir = new DirectoriCompilacioJugador();
		dir.AfegirFitxer(cc);
		Compilador c = new Compilador();
		// TODO CAL QUE COMPILADOR RETORNI UN RESULTAT FILE
		c.compilarJugador(dir.getDir());
		dir.Natejar();
		File f = null;
		object = new Fitxer(f);
	}
	
	
	
}
