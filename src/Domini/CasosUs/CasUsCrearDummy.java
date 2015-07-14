package Domini.CasosUs;

import Comunicacio.Fitxer;
import Domini.Factories.FactoriaControladors;
import Domini.Model.Dummy;
import Domini.Model.Huma;
import Domini.Transaccions.TxCompilarJugador;
import Excepcions.FitxerInvalid;

public class CasUsCrearDummy {
	public CasUsCrearDummy(){}
	public void CrearDummy(Fitxer dummy) throws Exception{
		Fitxer oo;
    	try{
    		TxCompilarJugador t = new TxCompilarJugador(dummy);
    		t.Executar();
    		oo = t.getResultat();
    	}
    	catch (Exception e){
    		throw new FitxerInvalid();
    		
    	}
    	
    	Dummy d = new Dummy();
       	d.setJugador(oo);
       	d.setName(dummy.getNomSenseExt());
       	FactoriaControladors.getInstance().getCtrlDummy().Insert(d);   

	}
}
