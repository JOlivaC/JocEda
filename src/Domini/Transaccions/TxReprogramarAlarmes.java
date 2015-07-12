package Domini.Transaccions;

import java.time.LocalTime;
import java.util.Date;

public class TxReprogramarAlarmes {
	private Date i;
	private Date f;
	private LocalTime in;
	private LocalTime fn;
	
	public TxReprogramarAlarmes(Date i, Date f, LocalTime in, LocalTime fn) {
		this.i = i;
		this.f = f;
		this.in = in;
		this.fn = fn;
	}
}
