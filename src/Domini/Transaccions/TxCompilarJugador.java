package Domini.Transaccions;

import java.io.File;

import Comunicacio.Fitxer;
import Domini.Directoris.DirectoriCompilacioJugador;
import Domini.Directoris.DirectoriHeaders;
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
		DirectoriCompilacioJugador dir = new DirectoriCompilacioJugador(cc.getNomSenseExt());
		dir.AfegirFitxer(cc);
		try{
			Compilador c = new Compilador();
			File f = c.compilarJugador(dir.getDirFitxer(),new DirectoriHeaders().getDir());
			object = new Fitxer(f);
		}
		catch (Exception e){
			throw e;
		}
		finally{
			dir.DestruirDirectori();
		}
		
	}
	
	
	
}
