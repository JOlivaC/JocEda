package Domini.Transaccions;

import java.time.LocalTime;
import java.util.Date;

import Domini.Factories.FactoriaControladors;

public class TxProgramarSessio {
	
	private Date i;
	private Date f;
	private LocalTime in;
	private LocalTime fn;
	
	public TxProgramarSessio(Date i, Date f, LocalTime in, LocalTime fn) {
		this.i = i;
		this.f = f;
		this.in = in;
		this.fn = fn;
	}
	public void Executar() throws Exception{
		new TxGenerarPartides().executar();
		new TxGenerarAlarmes(i,f,in,fn).Executar();
		new TxEngegarAlarmes().Executar();
	}
	
}
