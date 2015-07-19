package Domini.Transaccions;

import java.time.LocalTime;
import java.util.Date;

public class TxProgramarSessio {
	
	private Date i;
	private Date f;
	private LocalTime in;
	private LocalTime fn;
	private int IDLliga;
	
	public TxProgramarSessio(Date i, Date f, LocalTime in, LocalTime fn,int IDLliga) {
		this.i = i;
		this.f = f;
		this.in = in;
		this.fn = fn;
		this.IDLliga = IDLliga;
	}
	public void Executar() throws Exception{
		new TxGenerarPartides(IDLliga).executar();
		new TxGenerarAlarmes(i,f,in,fn,IDLliga).Executar();
		new TxEngegarAlarmes().Executar();
	}
	
}
